package com.baizhi.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.User;
import com.baizhi.results.Result;
import com.baizhi.service.UserServiceImpl;
import com.baizhi.utils.VerifyCodeUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController {

    private String name;
    private String pwd;
    private String code;


    /**
     * 退出登录
     */
    public String logout(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.invalidate();//session失效
        return "success";
    }


    /**
     * 生成验证码方法
     *
     * @throws IOException
     */
    public void getImage() throws IOException {
        //响应图片获取响应 response
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        //1.生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println("code: " + code);
        request.getSession().setAttribute("imageCode", code);
        //2.生成验证码图片   //3.通过response响应
        VerifyCodeUtils.outputImage(260, 80, response.getOutputStream(), code);
    }


    //ajax的请求方法
    public void login() throws IOException {
        System.out.println("username: " + name);
        System.out.println("pwd: " + pwd);
        System.out.println("用户输入的code: " + code);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("imageCode");
        System.out.println("从session中获取的数据:   " + sessionCode);

        Result result = new Result();//定义对象
        //如何获取响应对象
        HttpServletResponse response = ServletActionContext.getResponse();
        //设置类型
        response.setContentType("application/json;charset=UTF-8");

        try{
            //比较验证码忽略大小写比较
            if (sessionCode.equalsIgnoreCase(code)) {
                //验证登录 调用业务方法
                UserServiceImpl userService = new UserServiceImpl();
                User user = new User();
                user.setUsername(name);
                user.setPassword(pwd);
                User userDB = userService.login(user); //调用业务方法去按成登录
                session.setAttribute("user",userDB);//用户登录对象存入session中
                result.setMsg("登录成功,点击确定跳转之主页!");
                result.setStatus(true);
            } else {
               throw new RuntimeException("验证码输入错误!!!");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("登录失败: "+e.getMessage());
        }


        //转换result为json
        String json = JSON.toJSONString(result);
        response.getWriter().println(json);
    }


    //接收参数GET SET方法

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
