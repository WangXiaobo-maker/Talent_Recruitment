package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

}
