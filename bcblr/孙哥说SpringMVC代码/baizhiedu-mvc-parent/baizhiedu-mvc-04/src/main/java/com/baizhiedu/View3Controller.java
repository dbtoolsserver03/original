package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/view3")
@SessionAttributes(value={"name","address"})
public class View3Controller {

    @RequestMapping("/view1")
    public String view1(Model model) {
        model.addAttribute("age", 10);
        model.addAttribute("name", "xiaojr");
        return "result2";
    }
}
