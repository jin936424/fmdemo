package com.test.demo;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/***
 * Created by dz on 2020-1-15
 */
public class BlogVisit {

    @Test
    public void visit() throws IOException {
        String url = "http://www.blogdz.top/archives/2019121715274604421";
        BufferedReader reader = null;
        String result = "";
        try{
            URL readUrl = new URL(url);
            int i = 0;
            while(i <= 100){
                //打开连接
                URLConnection connection=readUrl.openConnection();
                // 设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("user-agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                //建立连接
                connection.connect();
                // 获取所有响应头字段
                Map<String, List<String>> map = connection.getHeaderFields();
                // 遍历所有的响应头字段，获取到cookies等
                for (String key : map.keySet()) {
                    System.out.println(key + "--->" + map.get(key));
                }
                // 定义 BufferedReader输入流来读取URL的响应
                reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),"UTF-8"));
                String line; //循环读取
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                i++;
                System.err.println(result);
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(reader!=null){//关闭流
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
