package com.anmi.anime.utils;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import monad.rpc.protocol.CommandProto;
import nirvana.hall.protocol.extract.ExtractProto;
import nirvana.hall.protocol.extract.FeatureDisplayProto;
import nirvana.hall.protocol.extract.LatentConverterExtractProto;
import nirvana.hall.protocol.image.FirmImageDecompressProto;
import nirvana.hall.protocol.image.ImageCompressProto;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by wangjue on 2017/9/6.
 */
public class ProtoHttpClientUtil {

    private static ExtensionRegistry registry = ExtensionRegistry.newInstance();
    private static String HTTP_PROTOBUF_HEADER = "X-Hall-Request";
    private static String HTTP_PROTOBUF_HEADER_VALUE = "ok";
    static {
        ExtractProto.registerAllExtensions(registry);
        FirmImageDecompressProto.registerAllExtensions(registry);
        ImageCompressProto.registerAllExtensions(registry);
        LatentConverterExtractProto.registerAllExtensions(registry);
        FeatureDisplayProto.registerAllExtensions(registry);
    }
    private final static CloseableHttpClient httpClient = ProtoHttpClientUtil.createHttpClient();
    /**
     * 通过protobuf的数据来调用远程的url
     * @param url web application url
     * @param extension  调用请求类
     */
    public static <Type> CommandProto.BaseCommand call(String url, GeneratedMessage.GeneratedExtension<CommandProto.BaseCommand,Type> extension, Type value){
        //System.out.println("-----------------------------------------------------------"+times);
        CloseableHttpClient httpClient = createHttpClient();
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader(HTTP_PROTOBUF_HEADER, HTTP_PROTOBUF_HEADER_VALUE);
            CommandProto.BaseCommand.Builder request = CommandProto.BaseCommand.newBuilder();
            request.setExtension(extension, value);
            request.setTaskId(1L);

            ByteArrayEntity reqEntity = new ByteArrayEntity(request.build().toByteArray());
            post.setEntity(reqEntity);

            CloseableHttpResponse response = httpClient.execute(post);
            try {
                if(response.getStatusLine().getStatusCode() == 200){
                    HttpEntity entity = response.getEntity();
                    try {
                        return CommandProto.BaseCommand.getDefaultInstance().getParserForType().parseFrom(entity.getContent(), registry);
                    } finally {
                        EntityUtils.consume(entity);
                    }
                }else {
                    throw new RuntimeException(response.getStatusLine().toString());
                }
            }finally {
                close(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(httpClient);
        }
    }

    /**
     * 下载文件
     * @param url
     * @return
     */
    public static byte[] download(String url) {
        CloseableHttpClient httpClient = createHttpClient();
        try {
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(get);
            try {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    try {
                        return IOUtils.toByteArray(entity.getContent());
                    } finally {
                        EntityUtils.consume(entity);
                    }
                } else return null;
            } finally {
                close(response);
            }
        } catch (IOException e) {
            return null;
        } finally {
            close(httpClient);
        }
    }

    private static void close(Closeable e) {
        try {
            e.close();
        }
        catch (Exception e1){
            e1.printStackTrace();

        }
    }

    private static CloseableHttpClient createHttpClient() {
        RequestConfig defaultConfig = RequestConfig.custom().
                setConnectTimeout(10 * 1000). //连接超时设置
                setSocketTimeout(30 * 1000). //读取时间设置
                build();
        return HttpClientBuilder.create().setDefaultRequestConfig(defaultConfig).setUserAgent("nirvana-hall/1.0").build();
    }
}
