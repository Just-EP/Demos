package pers.demos.crawlerbilibili.service;

import org.springframework.stereotype.Service;
import pers.demos.crawlerbilibili.bean.BiliBiliRankInfoPojo;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoServiceImpl
 * @description 实现
 * @createtime 2019/09/18 23:15:00
 */
@Service
public class BiliBiliRankInfoServiceImpl implements BiliBiliRankInfoService{
    @Override
    public void handleRankInfo(List<BiliBiliRankInfoPojo> rankInfos) {
        //没什么需要处理的,直接调用mapper入库
    }
}
