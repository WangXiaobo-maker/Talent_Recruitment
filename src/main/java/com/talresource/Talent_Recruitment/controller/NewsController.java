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

    @RequestMapping("/redirNews")
    public String redirNews(ModelMap map){
        map.addAttribute("NewsListByDate", newsService.selectNewsByDate());
        return "news";
    }

    @RequestMapping("/redirNewsContent")
    public String redirNewsContent(String NewsID, ModelMap map){

        int NewsID1 = Integer.parseInt(NewsID);
        newsService.updateNewsHeat(NewsID1);

        map.addAttribute("News", newsService.selectNewsByID(NewsID1));
        map.addAttribute("NewsListByHeat", newsService.selectNewsByHeat());
        return "newsContent";
    }

    @RequestMapping("/redirNewsEdit")
    public String redirNewsEdit(ModelMap map, int NewsID){
        map.addAttribute("News", newsService.selectNewsByID(NewsID));
        return "newsPublish";
    }

}
