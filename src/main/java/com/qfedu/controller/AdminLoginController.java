package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.utils.StrUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

@Controller
@Validated
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(@NotEmpty String username, @Size(min = 1,max = 10) String password, HttpSession session) {

        Admin admin = adminService.login(username, password);
        session.setAttribute(StrUtils.LOGIN_Admin,admin);

        JsonResult result = new JsonResult(1, null);

        return result;
    }

}
