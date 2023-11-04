package com.baizhiedu.filter;

import com.baizhiedu.util.Page;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String pageIndexString = req.getParameter("pageIndex");
        int pageIndex = Integer.parseInt(pageIndexString);
        Page page = new Page(pageIndex);

        //Tl.set(page)

        chain.doFilter(request,response);//--- DispatcherServlet ---- Controller --- Service ----DAO
    }

    @Override
    public void destroy() {

    }
}
