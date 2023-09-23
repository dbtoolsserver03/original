package com.baizhiedu;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/param2")
public class Param2Controller {

    @RequestMapping("/param6")
    public String param6(@RequestHeader("Host") String host) {
        System.out.println("host = " + host);
        return "param1";
    }

    @RequestMapping("/param5")
    public String param5(HttpServletRequest request) {
        String host = request.getHeader("Host");
        System.out.println("host = " + host);
        return "param1";
    }

    @RequestMapping("/param4")
    public String param4(@CookieValue("name") String value) {
        System.out.println("value = " + value);
        return "param1";
    }

    @RequestMapping("/param3")
    public String param3(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("name".equals(cookie.getName())) {
                System.out.println("cookie.getValue() = " + cookie.getValue());
            }
        }
        return "param1";
    }

    @RequestMapping("/param2")
    public String param2(@RequestParam MultiValueMap<String, String> params) {
        Set<String> keys = params.keySet();
        for (String key : keys) {
            List<String> values = params.get(key);
            System.out.println("key is " + key);
            for (String value : values) {
                System.out.println("value = " + value);
            }
        }
        return "param1";
    }

    @RequestMapping("/param1")
    public String param1(@RequestParam Map<String, String> params) {
        Set<String> keys = params.keySet();
        for (String key : keys) {
            System.out.println("key is " + key + " value is " + params.get(key));
        }
        return "param1";
    }
}
