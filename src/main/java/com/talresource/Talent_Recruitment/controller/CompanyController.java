package com.talresource.Talent_Recruitment.controller;

import com.talresource.Talent_Recruitment.entity.Company;
import com.talresource.Talent_Recruitment.entity.Result;
import com.talresource.Talent_Recruitment.entity.User;
import com.talresource.Talent_Recruitment.service.CompanyService;
import com.talresource.Talent_Recruitment.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //------------------------------------------------------视图管理------------------------------------------------------
    @RequestMapping("companyRegisterInfo")
    public String companyRegisterInfo(HttpSession session){
        Company company = (Company)session.getAttribute("company");
        Result result = (Result)session.getAttribute("result");
        if(company == null || result == null)
            return "redirect:redirRegister";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("注册成功"))
            return "companyRegisterInfo";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("下一步成功"))
            return "redirect:companyRegisterInfo2";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("提交成功"))
            return "redirect:home";
        if(result.getData() != null &&
                result.getData().getClass() == User.class &&
                result.getMessage().equals("注册成功"))
            return "redirect:userRegisterInfo";
        return "redirect:redirRegister";
    }

    @RequestMapping("companyRegisterInfo2")
    public String companyRegisterInfo2(HttpSession session){
        Company company = (Company)session.getAttribute("company");
        Result result = (Result)session.getAttribute("result");
        if(company == null || result == null)
            return "redirect:redirRegister";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("注册成功"))
            return "redirect:companyRegisterInfo";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("下一步成功"))
            return "companyRegisterInfo2";
        if(result.getData() != null &&
                result.getData().getClass() == Company.class &&
                result.getMessage().equals("提交成功"))
            return "redirect:home";
        if(result.getData() != null &&
                result.getData().getClass() == User.class &&
                result.getMessage().equals("注册成功"))
            return "redirect:userRegisterInfo";
        return "redirect:redirRegister";
    }


    //------------------------------------------------------数据管理------------------------------------------------------
    @RequestMapping("tocompanyRegisterInfo")
    @ResponseBody
    public Result tocompanyRegisterInfo(HttpSession session, String CompanyName, String CompanyPhone,
                                        String CompanyLegalPerson, String CompanyAddress){
        Result result = null;
        Company company = companyService.queryByName(CompanyName);
        Company company1 = (Company)session.getAttribute("company");
        if(company != null && company.getCompanyID() != company1.getCompanyID()){
            result = new Result(Config.STATUS_FAILURE,"该公司已被注册");
        }
        else {
            int CompanyID = company1.getCompanyID();
            int update = companyService.updateById(CompanyName, CompanyPhone, CompanyLegalPerson, CompanyAddress, CompanyID);
            if(update <= 0){
                result = new Result(Config.STATUS_ERROR,"下一步失败");
            }
            else{
                Company company2 = companyService.queryById(CompanyID);
                session.setAttribute("company", company2);
                result = new Result(Config.STATUS_SUCCESS,"下一步成功", company2);
                session.setAttribute("result", result);
            }
        }
        return result;
    }

    @RequestMapping("tocompanyRegisterInfo2")
    @ResponseBody
    public Result tocompanyRegisterInfo2(HttpSession session, String CompanyNature, String CompanyType,
                                        String CompanyCulture, String CompanyInfo){
        Result result = null;
        Company company = (Company)session.getAttribute("company");
        int CompanyID = company.getCompanyID();
        int update = companyService.updateById2(CompanyNature, CompanyType, CompanyCulture, CompanyInfo, CompanyID);
        if(update <= 0){
            result = new Result(Config.STATUS_ERROR,"提交失败");
        }
        else{
            Company company1 = companyService.queryById(CompanyID);
            session.setAttribute("company", company1);
            result = new Result(Config.STATUS_SUCCESS,"提交成功", company1);
            session.setAttribute("result", result);
        }
        return result;
    }


}
