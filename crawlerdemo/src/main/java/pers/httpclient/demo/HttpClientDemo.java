package pers.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author JustEP
 * @version 1.0
 * @classname HttpClient
 * @description TODO
 * @createtime 2019/06/28 22:08:00
 */
public class HttpClientDemo {
    private static HttpClient httpClient = HttpClients.createDefault();
    public static void main(String[] args) {
        try {
            HttpGet httpGet = new HttpGet("http://bbs.3dmgame.com/thread-5897348-1-1.html");
            HttpResponse res = httpClient.execute(httpGet);
            res.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
