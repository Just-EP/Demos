package pers.crawler.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @author JustEP
 * @version 1.0
 * @classname HttpClientCommon
 * @description 通用
 * @createtime 2019/07/14 15:19:00
 */
public class HttpClientCommon {
    private static BasicCookieStore cookieStore = new BasicCookieStore();
    private static CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    public static void main(String[] args) {
        new HttpClientCommon().getHtml("https://music.163.com/#/playlist?id=106464264");
    }
    public void getHtml(String url){
        try {
//            cookieStore.addCookie(new BasicClientCookie());
            HttpGet get = new HttpGet(url);
            get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            Header[] allHeaders = get.getAllHeaders();
            System.out.println(get);
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            String html = new String(EntityUtils.toString(entity,"UTF-8").getBytes(), "UTF-8");
            Document document = Jsoup.parse(html);
            Element body = document.body();
//            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
