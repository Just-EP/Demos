package pers.demos.crawlerbilibili.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import pers.demos.crawlerbilibili.bean.BiliBiliRankInfoPojo;
import pers.demos.crawlerbilibili.crawler.source.HttpClientDownloader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.xsoup.Xsoup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @classname DemoCrawler
 * @description 测试爬虫
 * @createtime 2019/09/17 22:03:00
 */
public class DemoCrawler implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private Logger logger = LoggerFactory.getLogger(DemoCrawler.class);
    @Override
    public void process(Page page) {
        List<String> lis = page.getHtml().xpath("//li[@class='rank-item']").all();
        List<BiliBiliRankInfoPojo> biliBiliRankInfoPojos = new ArrayList<>();
        for (String li : lis) {
            BiliBiliRankInfoPojo rankInfo = new BiliBiliRankInfoPojo();
            String rank = Xsoup.select(li, "//div[@class='num']/text()").get();
            rankInfo.setRank(rank);
            String title = Xsoup.select(li, "//div[@class='info']/a/text()").get();
            rankInfo.setTitle(title);
            String videoUrl = Xsoup.select(li, "//div[@class='info']/a/@href").get();
            videoUrl = videoUrl.substring(2);
            rankInfo.setVideoUrl(videoUrl);
            String play = Xsoup.select(li, "//div[@class='detail']/span[1]/text()").get();
            rankInfo.setPlay(play);
            String danmaku = Xsoup.select(li, "//div[@class='detail']/span[2]/text()").get();
            rankInfo.setDanmaku(danmaku);
            String author = Xsoup.select(li, "//div[@class='detail']/a/span/text()").get();
            rankInfo.setAuthor(author);
            String authorUrl = Xsoup.select(li, "//div[@class='detail']/a/@href").get();
            authorUrl = authorUrl.substring(2);
            rankInfo.setAuthorUrl(authorUrl);
            String score = Xsoup.select(li, "//div[@class='pts']/div[1]/text()").get();
            rankInfo.setScore(score);
            biliBiliRankInfoPojos.add(rankInfo);
            logger.info("bean:{}",rankInfo);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //b站排行榜url https://www.bilibili.com/ranking/
        //all全站榜，1动画区，1近期投稿，3三日排行
        Spider.create(new DemoCrawler()).setDownloader(new HttpClientDownloader()).addUrl("https://www.bilibili.com/ranking/all/1/1/3/").thread(5).run();
    }
}
