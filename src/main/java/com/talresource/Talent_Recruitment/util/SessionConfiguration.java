package com.talresource.Talent_Recruitment.util;

import com.talresource.Talent_Recruitment.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//登录拦截器
@Configuration
public class SessionConfiguration implements WebMvcConfigurer {

    @Autowired
    SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/static/**","/companyRegisterInfo","/companyRegisterInfo2",
                        "/tocompanyRegisterInfo","/tocompanyRegisterInfo2","/userInfoPage","/userInfoPageNoLogin",
                        "/companyCV","/dealApply","/companyInfoPage","/companyInfo","/companyUpdateInfo",
                        "/companyJob","/companyJobInfo","/companyAddJob","/companyUpdatePasswd","/getNature",
                        "/getJobCity","/getJobEduDegree","/searchJob","/deleteJob","/updateJob","/addJob",
                        "/managerCheck","/manager1","/manager2","/deleteNews","/saveNews","/deletePost",
                        "/requestkey","/redirNews","/redirNewsContent","/redirNewsEdit","/index","/home",
                        "/jobSearch","/forum","/redirForumSearch","/jobInfo","/companyIntro","/forumContent",
                        "/searchForum","/uploadCV","/redirLogin","/logout","/redirRegister","/forgotPwd",
                        "/tologin","/toregister","/toForgotPwd","/updateCompany","/toCompanyUpdatePasswd");
    }
}
