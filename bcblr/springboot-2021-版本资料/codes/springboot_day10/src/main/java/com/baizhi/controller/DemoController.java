package com.baizhi.controller;

import com.baizhi.exception.IllegalNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin //允许这个controller中所有请求 被 其他域访问
@RestController
@RequestMapping("demos")
public class DemoController {


    @GetMapping
    public ResponseEntity<String> demo() {
        System.out.println("demo ok");
        return new ResponseEntity<>("demo ok ", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> demo(@PathVariable("id") Integer id) {
        System.out.println("demo ok "+id);
        if(id<0) throw new IllegalNumberException("无效id,请检查!");
        return new ResponseEntity<>("demo ok ", HttpStatus.OK);
    }

}


