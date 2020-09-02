package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.Result;
import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.CompanyService;
import com.talresource.Talent_Recruitment.service.UserService;
import com.talresource.Talent_Recruitment.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    //------------------------------------------------------视图管理------------------------------------------------------
    @RequestMapping("redirLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        session.setAttribute("company",null);
        session.setAttribute("result",null);
        return "redirect:redirLogin";
    }

    @RequestMapping("redirRegister")
    public String register(){
        return "register";
    }

    @RequestMapping("userRegisterInfo")
    public String companyRegisterInfo(HttpSession session){
        User user = (User)session.getAttribute("user");
        Result result = (Result)session.getAttribute("result");
        if(user == null || result == null)
            return "redirect:redirRegister";
        if(result.getData() != null &&
                result.getData().getClass() == User.class &&
                result.getMessage().equals("注册成功"))
            return "userRegisterInfo";
        if(result.getData() != null &&
                result.getData().getClass() == User.class &&
                result.getMessage().equals("提交成功"))
            return "redirect:home";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("注册成功"))
            return "redirect:companyRegisterInfo";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("下一步成功"))
            return "redirect:companyRegisterInfo2";
        return "redirect:redirRegister";
    }

    @RequestMapping("forgotPwd")
    public String forgotPwd(){
        return "forgotPwd";
    }


    //------------------------------------------------------数据管理------------------------------------------------------
    @RequestMapping("tologin")
    @ResponseBody
    public Result tologin(HttpSession session, String email, String password, String type){
        Result result = null;
        if(type.equals("1")){
            User user = userService.queryByEmailAndPasswd(email, password);
            if(user == null){
                result = new Result(Config.STATUS_FAILURE,"邮箱或密码错误");
            }
            else{
                session.setAttribute("user",user);
                session.setAttribute("company",null);
                result = new Result(Config.STATUS_SUCCESS,"登录成功", user);
            }
        }
        else{
            Company company = companyService.queryByEmailAndPasswd(email, password);
            if(company == null){
                result = new Result(Config.STATUS_FAILURE,"邮箱或密码错误");
            }
            else{
                session.setAttribute("company",company);
                session.setAttribute("user",null);
                result = new Result(Config.STATUS_SUCCESS,"登录成功", company);
            }
        }
        return result;
    }

    @RequestMapping("toregister")
    @ResponseBody
    public Result toregister(HttpSession session, String email, String password,String type){
        Result result = null;
        if(type.equals("1")){
            User user = userService.queryByEmail(email);
            if(user != null){
                result = new Result(Config.STATUS_FAILURE,"该邮箱已被注册");
            }
            else {
                int insert = userService.insertOneUser(email, password);
                if(insert <= 0){
                    result = new Result(Config.STATUS_ERROR,"注册失败");
                }
                else{
                    User user1 = userService.queryByEmailAndPasswd(email, password);
                    session.setAttribute("user",user1);
                    session.setAttribute("company",null);
                    result = new Result(Config.STATUS_SUCCESS,"注册成功", user1);
                    session.setAttribute("result", result);
                }
            }
        }
        else{
            Company company = companyService.queryByEmail(email);
            if(company != null){
                result = new Result(Config.STATUS_FAILURE,"该邮箱已被注册");
            }
            else {
                int insert = companyService.insertOneCompany(email, password);
                if(insert <= 0){
                    result = new Result(Config.STATUS_ERROR,"注册失败");
                }
                else{
                    Company company1 = companyService.queryByEmailAndPasswd(email, password);
                    session.setAttribute("company", company1);
                    session.setAttribute("user",null);
                    result = new Result(Config.STATUS_SUCCESS,"注册成功", company1);
                    session.setAttribute("result", result);
                }
            }
        }
        return result;
    }

    @RequestMapping("touserRegisterInfo")
    @ResponseBody
    public Result touserRegisterInfo(HttpSession session, String UserName, String Sex, String NickName,
                                     String Birth, String UserPhone){
        Result result = null;
        User user = (User)session.getAttribute("user");
        int UserID = user.getUserID();
        int update = userService.updateById(UserName, Sex, NickName, Birth, UserPhone, UserID);
        if(update <= 0){
            result = new Result(Config.STATUS_ERROR,"提交失败");
        }
        else{
            User user1 = userService.queryById(UserID);
            session.setAttribute("user", user1);
            result = new Result(Config.STATUS_SUCCESS,"提交成功", user1);
            session.setAttribute("result", result);
        }
        return result;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public Result updateUser(HttpSession session, String UserName, String Sex, String NickName,
                             String Birth, String UserPhone, String UserEmail){
        Result result = null;
        User user = userService.queryByEmail(UserEmail);
        User user1 = (User)session.getAttribute("user");
        if(user != null && user.getUserID() != user1.getUserID()){
            result = new Result(Config.STATUS_FAILURE,"该邮箱已被使用");
        }
        else{
            int UserID = user.getUserID();
            int update = userService.updateUser(UserName, Sex, NickName, Birth, UserPhone, UserEmail, UserID);
            if(update <= 0){
                result = new Result(Config.STATUS_ERROR,"更新失败");
            }
            else{
                User user2 = userService.queryById(UserID);
                session.setAttribute("user", user2);
                result = new Result(Config.STATUS_SUCCESS,"更新成功", user2);
                session.setAttribute("result", result);
            }
        }
        return result;
    }

    @RequestMapping("toUpdatePasswd")
    @ResponseBody
    public Result toUpdatePasswd(HttpSession session, String OldPassword, String NewPassword){
        Result result = null;
        User user = (User)session.getAttribute("user");
        String UPassword = user.getUPassword();
        if(!OldPassword.equals(UPassword)){
            result = new Result(Config.STATUS_FAILURE,"原密码错误");
        }
        else {
            int UserID = user.getUserID();
            int update = userService.updatePasswd(NewPassword, UserID);
            if(update <= 0){
                result = new Result(Config.STATUS_ERROR,"密码修改失败");
            }
            else{
                User user1 = userService.queryById(UserID);
                session.setAttribute("user", user1);
                result = new Result(Config.STATUS_SUCCESS,"密码修改成功", user1);
                session.setAttribute("result", result);
            }
        }
        return result;
    }

    @RequestMapping("toForgotPwd")
    @ResponseBody
    public Result toForgotPwd(String email, String phone, String name, String password, String type){
        Result result = null;
        if(type.equals("1")){
            User user = userService.queryByEmPhNa(email, phone, name);
            if(user == null)
                result = new Result(Config.STATUS_FAILURE,"用户邮箱/电话/姓名错误");
            else {
                int UserID = user.getUserID();
                int update = userService.updatePasswd(password, UserID);
                if(update <= 0)
                    result = new Result(Config.STATUS_ERROR,"用户密码重置失败");
                else{
                    result = new Result(Config.STATUS_SUCCESS,"用户密码重置成功");
                }
            }
        }
        else {
            Company company = companyService.queryByEmPhNa(email, phone, name);
            if(company == null)
                result = new Result(Config.STATUS_FAILURE,"公司邮箱/电话/名称错误");
            else{
                int CompanyID = company.getCompanyID();
                int update = companyService.updatePasswd(password, CompanyID);
                if(update <= 0)
                    result = new Result(Config.STATUS_ERROR,"公司密码重置失败");
                else{
                    result = new Result(Config.STATUS_SUCCESS,"公司密码重置成功");
                }
            }
        }
        return result;
    }
}
