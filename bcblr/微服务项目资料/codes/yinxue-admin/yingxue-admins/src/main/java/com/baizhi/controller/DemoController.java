package com.baizhi.controller;

import com.baizhi.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    //201
    @GetMapping("/demo")
    public void demo() {
        log.info("demo ok");
    }

    //没有返回值: delete  update
    @GetMapping("/demos")
    public ResponseEntity<Void> demos() {
        log.info("demos");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //查询有返回值 查询
    @GetMapping("/demoss")
    public ResponseEntity<Admin> demoss() {
        return new ResponseEntity<Admin>(new Admin(), HttpStatus.OK);
    }

    //创建  nodejs  vue
    @GetMapping("/create")
    public ResponseEntity<Void> create() {
        //return new ResponseEntity<Void>(HttpStatus.CREATED);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("token", "xiaochen");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
