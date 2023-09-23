package com.concat.controller;

import com.concat.entity.User;
import com.concat.service.UserService;
import com.concat.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    private Map<String,Object> result = new HashMap<>();

    //登录方法
    @GetMapping("/login")
    public Map<String,Object> login(String username, String password, String role, HttpSession session){
        User login = userService.login(username, password,role);
        if(login==null){
            result.put("state",false);
            result.put("msg","登录失败: 用户名或密码错误!");
        }else{
            result.put("state",true);
            result.put("msg","登录成功: 点击确定进入系统..");
            result.put("user",login);
        }
        return result;
    }

    //注册方法
    @PostMapping("/register")
    public String register(User user,String code,HttpSession session){
        String sessionCode = (String) session.getAttribute("code");
        if(sessionCode.equalsIgnoreCase(code)){
            userService.register(user);
            return "redirect:/index";//跳转到登录界面
        }else{
            return "redirect:/toRegister";
        }
    }

    //生成验证码
    @GetMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);//存入session作用域中
        //响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);
    }
}
