package pers.demos.crawlerbilibili.service;

import pers.demos.crawlerbilibili.bean.BiliBiliRankInfoPojo;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoService
 * @description TODO
 * @createtime 2019/09/18 23:12:00
 */
public interface BiliBiliRankInfoService {
    /**
     * 处理RankInfo
     * @param rankInfos 获取的rank数据
     * */
    void handleRankInfo(List<BiliBiliRankInfoPojo> rankInfos);
}
