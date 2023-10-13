package com.ph.share.share.quartz.service;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class HelloSpringService {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void ds() {
        System.out.println("-=-=-==-"+dataSource);
    }

    public String helloSpring() {
        return "hello spring";
    }
}
