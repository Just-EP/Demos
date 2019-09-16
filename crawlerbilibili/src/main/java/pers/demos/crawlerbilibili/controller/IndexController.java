package pers.demos.crawlerbilibili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JustEP
 * @version 1.0
 * @classname IndexController
 * @description 首页
 * @createtime 2019/09/13 11:21:00
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }
}
