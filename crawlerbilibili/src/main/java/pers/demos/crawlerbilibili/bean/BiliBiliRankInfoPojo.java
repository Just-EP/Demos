package pers.demos.crawlerbilibili.bean;

import lombok.Data;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoPojo
 * @description TODO
 * @createtime 2019/09/18 22:35:00
 */
@Data
public class BiliBiliRankInfoPojo {
    private String rank;
    private String title;
    private String videoUrl;
    private String play;
    private String danmaku;
    private String author;
    private String authorUrl;
    private String score;
}
