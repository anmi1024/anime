package com.anmi.anime.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.anmi.anime.config.HBaseConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.io.compress.Compression.Algorithm;
import org.apache.hadoop.hbase.util.Bytes;


public class HBaseUtil {
	
	public static final String TABLE_NAME = "FPT_DATA_TABLE";
	public static final String COLUMN_FAMILY_IMG = "CF_IMG";
	public static final String COLUMN_FAMILY_MNT = "CF_MNT";
	public static final String COLUMN_FAMILY_IMG_MNT = "CF_IMG_MNT";
	
	
	public static Configuration configuration;
	static {
		InputStream inStream =  HBaseUtil.class.getResourceAsStream("/linkConfig.properties");
		Properties pop = new Properties();
		try {
			pop.load(inStream);
			String hbase_master = pop.getProperty("hbaseMaster");
			String zoo_quorum = pop.getProperty("zooQuorum");
			String zoo_port = pop.getProperty("zooPort");
			configuration = HBaseConfiguration.create();
			configuration.set("hbase.zookeeper.quorum", zoo_quorum); 
			configuration.set("hbase.zookeeper.property.clientPort", zoo_port); 
	        configuration.set("hbase.master", hbase_master); 
	        configuration.set("hbase.client.pause", "50");
	        configuration.set("hbase.client.retries.number", "3");
	        configuration.set("hbase.rpc.timeout", "2000");
	        configuration.set("hbase.client.operation.timout", "3000");
		} catch (IOException e) {
			e.printStackTrace();
		}
        /*HBaseUtil hBaseUtil = new HBaseUtil();
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", hBaseUtil.zooQuorum);
        configuration.set("hbase.zookeeper.property.clientPort", hBaseUtil.zooPort);
        configuration.set("hbase.master", hBaseUtil.hbaseMaster);
        configuration.set("hbase.client.pause", "50");
        configuration.set("hbase.client.retries.number", "3");
        configuration.set("hbase.rpc.timeout", "2000");
        configuration.set("hbase.client.operation.timout", "3000");*/
	}
	
	public static void createOrOverwriteTable(Admin admin,HTableDescriptor table) throws IOException{
		if (admin.tableExists(table.getTableName())) {
			admin.disableTable(table.getTableName());
			admin.deleteTable(table.getTableName());
		}
		admin.createTable(table);
	}
	

	public static void createSchemaTables() throws IOException {
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Admin admin = connection.getAdmin()) {
			HTableDescriptor table = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
			table.addFamily(new HColumnDescriptor(COLUMN_FAMILY_IMG));
			table.addFamily(new HColumnDescriptor(COLUMN_FAMILY_MNT));
			table.addFamily(new HColumnDescriptor(COLUMN_FAMILY_IMG_MNT));
			System.out.println("Creating table .......");
			createOrOverwriteTable(admin,table);
			System.out.println("Done!");
		}
	}
	
	public static void addColumnFamily(String columnName) throws IOException{
		Connection connection = ConnectionFactory.createConnection(configuration);
		Admin admin = connection.getAdmin();
		try {
			System.out.println("add column family 【"+ columnName +"】......");
			admin.disableTable(TableName.valueOf(TABLE_NAME));
			HColumnDescriptor column = new HColumnDescriptor(columnName);
			admin.addColumn(TableName.valueOf(TABLE_NAME), column.setCompactionCompressionType(Algorithm.NONE));
			System.out.println("add column family done!");
		} catch (IOException ex) {
			throw ex;
		} finally {
			admin.enableTable(TableName.valueOf(TABLE_NAME));
		}
	}
	

	public static void addSingleRow(String rowKey,String columnFamily,String qualifier ,byte[] value) throws IOException {
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME))) {
			//System.out.println("add data 【 "+rowKey+":"+columnFamily+":"+qualifier+" 】......");
			Put put = new Put(Bytes.toBytes(rowKey));
			put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier),value);
			table.put(put);
			//System.out.println("add done!");
		}
	}

	public static void addMultiRows(String rowKey,String columnFamily,String qualifier[],List<byte[]> values) throws IOException {
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME))) {
			Put put = new Put(Bytes.toBytes(rowKey));
			for (int i=0;i<qualifier.length;i++) {
				System.out.println("add data 【 "+columnFamily+":"+qualifier[i]+" 】......");
				put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier[i]),values.get(i));
			}
			table.put(put);
			System.out.println("add done!");
		}
	}
	
	
	public static void scanTable() throws IOException{
		ResultScanner rs = null;
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME))) {
			Scan scan = new Scan();
			rs = table.getScanner(scan);
			for (Result r : rs) {
                for (Cell c : r.rawCells()) {
                	System.out.println("row:" +Bytes.toString(CellUtil.cloneRow(c)));
                    System.out.println("family:"+ Bytes.toString(CellUtil.cloneFamily(c)));
                    System.out.println("qualifier:"+ Bytes.toString(CellUtil.cloneQualifier(c)));
                    //System.out.println("value:" + Bytes.toString(CellUtil.cloneValue(c)));
                    System.out.println("timestamp:" + c.getTimestamp());
                    System.out
                            .println("-------------------------------------------");
                }
            }
		} finally {
			rs.close();
		}
	}
	
	public static Result getResultByRowKey(String rowKey) throws IOException {
		Result result  = null;
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME));) {
			Get get = new Get(Bytes.toBytes(rowKey));
			result = table.get(get);

		}
		return result;
	}
	
	public static Result getResultByColumnFamily(String rowKey,String columnFamilys[]) throws IOException {
		Result result  = null;
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME));) {
			Get get = new Get(Bytes.toBytes(rowKey));
			for (String columnFamily : columnFamilys)
				get.addFamily(Bytes.toBytes(columnFamily));
			result = table.get(get);

		}
		return result;
	}
	
	public static Result getResultByColumn(String rowKey,String columnFamily,String columnName) throws IOException {
		Result result  = null;
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME));) {
			Get get = new Get(Bytes.toBytes(rowKey));
			get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnName));
			result = table.get(get);
            for (Cell c : result.rawCells()) {
            	System.out.println("row:" +Bytes.toString(CellUtil.cloneRow(c)));
                System.out.println("family:"+ Bytes.toString(CellUtil.cloneFamily(c)));
                System.out.println("qualifier:"+ Bytes.toString(CellUtil.cloneQualifier(c)));
                System.out.println("value:" + Bytes.toString(CellUtil.cloneValue(c)));
                System.out.println("timestamp:" + c.getTimestamp());
                System.out
                        .println("-------------------------------------------");
            }

		}
		return result;
	}
	
	public static void deleteResultByRowKey(String rowKey) throws IOException{
		try (Connection connection = ConnectionFactory.createConnection(configuration);
				Table table = connection.getTable(TableName.valueOf(TABLE_NAME));) {
			Delete delete = new Delete(Bytes.toBytes(rowKey));
			System.out.println(rowKey + " deleteing");
			table.delete(delete);
			System.out.println(rowKey+" is deleteed!");
		}
	}
	
	public static void main(String[] args) {
		try {
			//创建表
			//createSchemaTables();
			//添加列族(列族数量别太多！！！！！！！)
			addColumnFamily("P0000000000000000000011");

			//添加单行
			addSingleRow("P0000000000000000000001",COLUMN_FAMILY_IMG,"0_1","ABC_IMG".getBytes());
			addSingleRow("P0000000000000000000001",COLUMN_FAMILY_IMG_MNT,"0_1","ABC_CBA_IMG".getBytes());

			//添加列族及多行
			String qualifiers[] = new String[]{"0_1","0_5","0_9"};
			List<byte[]> values = new ArrayList<byte[]>();
			values.add("a".getBytes());
			values.add("b".getBytes());
			values.add("c".getBytes());
			addMultiRows("P0000000000000000000001",COLUMN_FAMILY_MNT,qualifiers,values);

			//扫描表
			//scanTable();
			//根据行键获取数据
			getResultByRowKey("P1201606081465354415164");
			//
			//getResultByColumnFamily("P1201606081465354415164",new String[]{COLUMN_FAMILY_IMG,COLUMN_FAMILY_IMG_MNT});
			//根据列明获取数据
			getResultByColumn("FPT_MNT","P0000000000000000000002","0_9");

			//
			deleteResultByRowKey("R3205086600002016080016");

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
