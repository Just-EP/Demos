package pers.jsoup.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static sun.util.logging.LoggingSupport.log;

/**
 * @author JustEP
 * @version 1.0
 * @classname JsoupDemo
 * @description TODO
 * @createtime 2019/05/31 22:14:00
 */
public class JsoupDemo {
    public static void main(String[] args) {
        try {
            Document  doc = Jsoup.connect("http://baidu.com/").get();
            String text = doc.head().html();
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
