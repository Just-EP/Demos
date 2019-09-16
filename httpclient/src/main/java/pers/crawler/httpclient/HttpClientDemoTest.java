package pers.crawler.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author JustEP
 * @version 1.0
 * @classname HttpClientDemo
 * @description 测试httpClient，试着使用httpclient和jsoup获取B站排行榜信息
 * @createtime 2019/07/08 22:14:00
 */
public class HttpClientDemoTest {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    @Test
    public void getBiliBiliRanking() {
        //b站排行榜url https://www.bilibili.com/ranking/
        //all全站榜，1动画区，1近期投稿，3三日排行
        try {
            String url = "https://www.bilibili.com/ranking/all/1/1/3/";
            HttpGet get = new HttpGet(url);
            get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            String html = new String(EntityUtils.toString(entity,"UTF-8").getBytes(), "UTF-8");
            Document document = Jsoup.parse(html);
            System.out.println(document);
            HtmlCleaner htmlCleaner = new HtmlCleaner();
            TagNode clean = htmlCleaner.clean(document.toString());
//            clean.evaluateXPath()
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
