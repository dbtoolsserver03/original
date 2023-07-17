package com.baizhi;

import com.baizhi.entity.Dept;
import com.baizhi.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by HIAPAD on 2019/11/15.
 */
@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class DeptServiceTest {
    @Autowired
    private DeptService deptService;

    @Test
    public void test(){
        List<Dept> list = deptService.findAll();

    }
}
