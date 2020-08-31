package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.NewsService;
import com.talresource.Talent_Recruitment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ManagerController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private PostService postService;

    @RequestMapping("/managerOptions")
    public String managerOptions(){
        return "manager/managerOptions";
    }

    @RequestMapping("/manager1")
    public String manager1(ModelMap map){
        map.addAttribute("NewsList", newsService.selectAllNews());
        return "manager/manager1";
    }

    @RequestMapping("/manager2")
    public String manager2(ModelMap map){
        map.addAttribute("PostList", postService.selectAllPost());
        return "manager/manager2";
    }

    @RequestMapping("/deleteNews")
    public String deleteNews(ModelMap map, String NewsID){
        int id = Integer.parseInt(NewsID);
        if (newsService.deleteNewsByID(id)){
            map.addAttribute("NewsList", newsService.selectAllNews());
            return "manager/manager1";
        }
        return "manager/manager1";
    }

    @RequestMapping("/saveNews")
    public String saveNews(ModelMap map, String NewsID, String NewsTitle, String NewsContent){

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String NewsPublishDate = sdf.format(today);

        String NewsBriefInfo = NewsContent.substring(30);

        int NewsID1 = Integer.parseInt(NewsID);

        if (NewsID1 == 0){
            if (newsService.insertNews(NewsTitle, NewsPublishDate, NewsBriefInfo, NewsContent)){
                map.addAttribute("NewsList", newsService.selectAllNews());
                return "manager/manager1";
            }
        }else {
            if (newsService.updateNewsById(NewsTitle, NewsPublishDate, NewsContent, NewsID1)){
                map.addAttribute("NewsList", newsService.selectAllNews());
                return "manager/manager1";
            }
        }
        return "error";
    }


    @RequestMapping("/deletePost")
    public String deletePost(ModelMap map, String PostID){
        int id = Integer.parseInt(PostID);
        if (postService.deletePostByID(id)){
            map.addAttribute("PostList", postService.selectAllPost());
            return "manager/manager2";
        }
        map.addAttribute("PostList", postService.selectAllPost());

        return "manager/manager2";
    }
}
