package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/newsTest1")
    public String newsTest1(ModelMap map){
        map.addAttribute("newsList", newsService.selectAllNews());
        return "test2";
    }

    @RequestMapping("/newsTest2")
    public String newsTest2(ModelMap map){
        return "news";
    }

    @RequestMapping("/newsTest3")
    public String newsTest3(ModelMap map){
        return "newsContentTest";
    }

    @RequestMapping("/redirNews")
    public String redirNews(ModelMap map){
        map.addAttribute("NewsListByDate", newsService.selectNewsByDate());
        return "news";
    }

    @RequestMapping("/redirNewsContent")
    public String redirNewsContent(){
        return "newContent";
    }
}
