package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HIAPAD on 2019/11/15.
 */
@Controller
@RequestMapping("test")
public class TestController {


    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<String> list = (List<String>) request.getSession().getAttribute("list");

        if(list==null){
            list = new ArrayList<>();
        }
        list.add("xxxxx");
        request.getSession().setAttribute("list",list);
        response.getWriter().println("sessionId: "+request.getSession().getId());
        response.getWriter().println("counts: "+list.size());
        //清除
        //正常退出 request.getSession().invalidate();

    }


}
