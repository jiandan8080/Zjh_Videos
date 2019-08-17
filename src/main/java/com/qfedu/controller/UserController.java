package com.qfedu.controller;

        import com.qfedu.common.JsonResult;
        import com.qfedu.entity.User;
        import com.qfedu.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public JsonResult login(String email, String password, HttpServletRequest request) {

        HttpSession session = request.getSession();

        JsonResult result = new JsonResult();

        try {
            User user = userService.login(email, password);
            session.setAttribute("user", user);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());

        }

        return result;

    }

    @RequestMapping("/regist.do")
    public JsonResult regist(String email, String password, String pswagain) {

        JsonResult result = new JsonResult();

        try {
            userService.add(email, password, pswagain);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/myInfo.do")
    public JsonResult getInfo(HttpServletRequest request) {

        HttpSession session = request.getSession();

        JsonResult result = new JsonResult();

        User user = (User) session.getAttribute("user");

        if (user != null) {
            result.setCode(1);
            result.setInfo(user);
            return result;
        } else {
            result.setCode(0);
            result.setInfo("请登录");
            return result;
        }

    }

    @RequestMapping("/update.do")
    public JsonResult updateUser(User user) {

        JsonResult result = new JsonResult();

        try {
            userService.update(user);
            result.setCode(1);            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return result;
    }

}
