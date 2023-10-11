package com.baizhi.controller;

import com.baizhi.constants.RedisPrefix;
import com.baizhi.dto.AdminDTO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2021-07-15 16:14:00
 */
@RestController
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private AdminService adminService;
    private RedisTemplate redisTemplate;

    
    @Autowired
    public AdminController(AdminService adminService, RedisTemplate redisTemplate) {
        this.adminService = adminService;
        this.redisTemplate = redisTemplate;
    }


    //登出接口
    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable("token") String token) {
        // redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(RedisPrefix.TOKEN_KEY + token);
    }

    //已登录用户信息  //vo value object view object   //dto data transfer object  推荐
    @GetMapping("/admin-user")
    public AdminDTO admin(String token) {
        log.info("当前token信息: {}", token);
        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        Admin admin = (Admin) redisTemplate.opsForValue().get(RedisPrefix.TOKEN_KEY + token);
        AdminDTO adminDTO = new AdminDTO();
        //1.属性复制
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    //登录接口
    @PostMapping("/tokens")
    public Map<String, String> tokens(@RequestBody Admin admin, HttpSession session) {
        Map<String, String> result = new HashMap<>();
        //1.new ObjectMapper fastjson JSONObject.tojsonString(admin)  jackson  new ObjectMapper().writerValueAsString(对象)
        log.info("接收到admin对象为: {}", JSONUtils.writeJSON(admin));
        //2.进行登录
        Admin adminDB = adminService.login(admin);
        //3.登录成功
        String token = session.getId();
        // redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(RedisPrefix.TOKEN_KEY + token, adminDB, 30, TimeUnit.MINUTES);
        result.put("token", token);
        return result;
    }

}
