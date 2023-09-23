package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/view2")
public class View2Controller {

    @RequestMapping("/view3")
    public String view3(ModelMap modelMap) {
        modelMap.addAttribute("name", "xiaowb");
        return "result1";
    }

    @RequestMapping("/view2")
    public String view2(Model model) {
        model.addAttribute("name", "xiaojr");
        return "redirect:/result1.jsp";
    }

    @RequestMapping("/view1")
    public String view1(HttpServletRequest request) {
        System.out.println("View2Controller.view1");

        request.setAttribute("name", "xiaojr");
        return "result1";
    }
}
