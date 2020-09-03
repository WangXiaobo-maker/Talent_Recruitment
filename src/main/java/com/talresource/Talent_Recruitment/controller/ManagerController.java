package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.CommentService;
import com.talresource.Talent_Recruitment.service.NewsService;
import com.talresource.Talent_Recruitment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ManagerController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/managerCheck")
    public String managerCheck(HttpSession session){
        session.removeAttribute("key");
        return "manager/managerCheck";
    }

    @RequestMapping("/manager1")
    public String manager1(HttpSession session,ModelMap map){
        if(session.getAttribute("key") == null)
            return "redirect:managerCheck";
        map.addAttribute("NewsList", newsService.selectAllNews());
        return "manager/manager1";
    }

    @RequestMapping("/manager2")
    public String manager2(HttpSession session, ModelMap map){
        if(session.getAttribute("key") == null)
            return "redirect:managerCheck";
        map.addAttribute("PostList", postService.selectAllPost());
        return "manager/manager2";
    }

    @RequestMapping("/deleteNews")
    public String deleteNews(HttpSession session, ModelMap map, String NewsID){
        if(session.getAttribute("key") == null)
            return "redirect:managerCheck";
        int id = Integer.parseInt(NewsID);
        if (newsService.deleteNewsByID(id)){
            return "redirect:manager1";
        }
        return "redirect:manager1";
    }

    @RequestMapping("/saveNews")
    public String saveNews(HttpSession session, ModelMap map, String NewsID, String NewsTitle, String NewsContent){

        if(session.getAttribute("key") == null)
            return "redirect:managerCheck";

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String NewsPublishDate = sdf.format(today);

        String NewsBriefInfo = NewsContent.substring(30);

        int NewsID1 = Integer.parseInt(NewsID);

        if (NewsID1 == 0){
            if (newsService.insertNews(NewsTitle, NewsPublishDate, NewsBriefInfo, NewsContent)){
                return "redirect:manager1";
            }
        }else {
            if (newsService.updateNewsById(NewsTitle, NewsPublishDate, NewsContent, NewsID1)){
                return "redirect:manager1";
            }
        }
        return "redirect:manager1";
    }


    @RequestMapping("/deletePost")
    public String deletePost(HttpSession session, ModelMap map, String PostID){

        if(session.getAttribute("key") == null)
            return "redirect:managerCheck";

        int id = Integer.parseInt(PostID);
        if (postService.deletePostByID(id) && commentService.deleteCommentByPost(id)){
            return "redirect:manager2";
        }
        return "redirect:manager2";
    }


    @RequestMapping("/requestkey")
    @ResponseBody
    public boolean requestkey(HttpSession session){
        session.setAttribute("key", "true");
        return true;
    }
}
