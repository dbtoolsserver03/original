package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //用户列表
    @GetMapping
    public Map<String, Object> users(@RequestParam(value = "page", defaultValue = "1") Integer pageNow,
                                     @RequestParam(value = "per_page", defaultValue = "5") Integer rows,
                                     @RequestParam(required = false) String id,
                                     String name,
                                     String phone) {
        Map<String, Object> result = new HashMap<>();
        log.info("分页信息 当前页:{} ,每页展示记录数: {}", pageNow, rows);
        log.info("搜索的值 id:{}, name:{}, phone:{}", id, name, phone);
        //查询用户 分页查询用户信息  指定条件分页查询用户信息
        List<User> items = userService.findAllByKeywords(pageNow, rows, id, name, phone);
        //查询总条数
        Long totalCounts = userService.findTotalCountsByKeywords(id, name, phone);
        log.info("当前list中的总数: {}", items.size());
        log.info("当前符合条件的总数: {}", totalCounts);
        result.put("total_count", totalCounts);
        result.put("items", items);
        return result;
    }
}
