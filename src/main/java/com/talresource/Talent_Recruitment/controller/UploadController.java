package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("uploadCV")
    public String uploadCV(HttpSession session, @RequestParam("file") MultipartFile file) throws IOException {

        File project = new File("");
        String projectPath = project.getCanonicalPath();
        User user = (User)session.getAttribute("user");
        int UserID = user.getUserID();
        String imgname = UserID + ".png";
        String path1 = projectPath + "\\src\\main\\resources\\static\\img\\CVImg";
        File filepath1 = new File(path1, imgname);
        if (!filepath1.getParentFile().exists()) {
            filepath1.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(path1 + File.separator + imgname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:myCV";
    }
}