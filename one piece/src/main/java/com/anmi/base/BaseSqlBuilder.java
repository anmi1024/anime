package com.anmi.base;

import com.anmi.annotation.Column;
import com.anmi.annotation.Entity;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangjue on 2017/7/19.
 */
public class BaseSqlBuilder {

    public String getAllSql(Class<?> type) {
        String TABLE_NAME = buildTableAndColumn(type).get(type.getSimpleName());
        String sql = new SQL(){{
            SELECT("*");
            FROM(TABLE_NAME);
        }}.toString();
        return sql;
    }

    public String getByPropertiesSql(Class<?> type,Map<String,Object> properties) throws Throwable{
        Map<String,String> tableAndColumn = buildTableAndColumn(type);
        String TABLE_NAME = tableAndColumn.get(type.getSimpleName());
        String sql = new SQL(){{
            SELECT("*");
            FROM(TABLE_NAME);
            for (String keys :properties.keySet()) {
                String op = "eq";
                String logic = "and";
                String key = "";
                if (keys.indexOf("_") != -1) {
                    String[] keyAndOp = keys.split("_");
                    key = keyAndOp[0];
                    if (keyAndOp.length == 2)
                        op = keyAndOp[1];
                    else if (keyAndOp.length == 3)
                        logic = keyAndOp[2];
                }
                if (keys.indexOf("&") != -1) { //GROUP BY ; ORDER BY
                    String[] keyAndOp = keys.split("&");
                    key = keyAndOp[0];
                    op = keyAndOp[1];
                }
                String columnName = tableAndColumn.get(key);
                Object columnValue = properties.get(keys);
                /*Type t = type.getDeclaredField(key).getType();
                if (t == String.class) columnValue = "'"+columnValue+"'";*/
                if ("or".equals(logic)) OR();
                if ("group-by".equals(op)) GROUP_BY(columnName);
                if ("order-by".equals(op)) ORDER_BY(columnName);
                if ("eq".equals(op)) WHERE(columnName +"="+ columnValue);
                else if ("non-eq".equals(op)) WHERE(columnName +"<>"+ columnValue);
                else if ("null-eq".equals(op)) WHERE(columnName + "is null");
                else if ("not-null-eq".equals(op)) WHERE(columnName + "is not null");
                else if ("like".equals(op)) WHERE(columnName +" like '%"+ columnValue +"%'");
                else if ("suf-like".equals(op)) WHERE(columnName +" like '%"+ columnValue+"'");
                else if ("pre-like".equals(op)) WHERE(columnName +" like '"+ columnValue +"%'");
                else if ("in".equals(op)) WHERE(columnName +" in ("+ columnValue +")");
                else if ("not-in".equals(op)) WHERE(columnName +" not in ("+ columnValue +")");
                else if ("gt".equals(op)) WHERE(columnName +">"+ columnValue);
                else if ("egt".equals(op)) WHERE(columnName +">="+ columnValue);
                else if ("lt".equals(op)) WHERE(columnName +"<"+ columnValue);
                else if ("elt".equals(op)) WHERE(columnName +"<="+ columnValue);
            }
        }}.toString();
        System.out.println(sql);
        return sql;
    }


    /**
     * 根据实体类获取数据库表名和列名
     * 定义注解则获取注解值，否则获取类名或属性名
     * @param clazz
     * @return
     */
    private Map<String,String> buildTableAndColumn(Class<?> clazz) {
        Map<String,String> tableAndColumns = new HashMap<>();
        String className = clazz.getSimpleName();
        String tableName = className;
        String aliasName = className.toLowerCase().substring(0,6);
        if (clazz.isAnnotationPresent(Entity.class)) {
            Entity entity = clazz.getAnnotation(Entity.class);
            tableName = entity.value();
        }
        tableAndColumns.put(className,tableName+" " +tableName);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String columnName = fieldName;
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                columnName = column.value();
            }
            columnName = tableName+"."+columnName;
            tableAndColumns.put(fieldName,columnName);
        }
        return tableAndColumns;
    }

}
