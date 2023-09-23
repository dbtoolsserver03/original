package com.baizhiedu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BServlet.service");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        System.out.println("name = " + name);
        System.out.println("password = " + password);
    }
}
