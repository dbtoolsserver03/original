package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.util.UriEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

//用户开发用户模块功能
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 用户登录
     * @return
     */
    @RequestMapping("login")
    public String login(String username,String password,HttpSession session) throws UnsupportedEncodingException {
        log.debug("接收到用户名:{}, 接收到密码:{}",username,password);
        try {
            //1.执行登录业务逻辑
            User user = userService.login(username,password);
            //2.登录成功,保存用户登录标记
            session.setAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8");
        }
        return "redirect:/employee/list";
    }

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("register")
    public String register(User user, String code,HttpSession session) throws UnsupportedEncodingException {
        log.debug("接收到验证码: {}",code);
        log.debug("用户名:{}, 真实姓名:{}, 密码:{}, 性别:{}",user.getUsername(),user.getRealname(),user.getPassword(),user.getGender());

        try {
            //1.比较验证是否一致
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误!");
            //2.注册用户
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/regist.jsp?msg="+ URLEncoder.encode(e.getMessage(),"UTF-8");
        }
        return "redirect:/login.jsp";
    }


    /**
     * 用来生成验证码方法
     */
    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        //1.生成随机字符串
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.保存随机字符串到Session中
        session.setAttribute("code",code);
        //3.将随机字符串生成图片
        //4.通过response响应图片
        response.setContentType("image/png");//指定响应类型
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(220,80,os,code);
    }
}
