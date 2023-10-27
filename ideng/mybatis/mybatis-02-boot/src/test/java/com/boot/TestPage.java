package com.boot;

import com.boot.entity.User;
import com.boot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = AppMyBatis.class)
public class TestPage {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testPageHelper(){
        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(2, 10);

        //PageHelpler:会使用该SQL语句 进行物理分页 没有执行查询所有的
        List<User> list = userMapper.listAll();


        //逻辑分页:就是将所有的数据查询出来 在程序中进行分页 效率非常低
        //物理分页:利用数据库limit进行分页
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);

        page.getList().forEach(System.out::println);
        System.out.println("总页数:"+page.getPages());
        System.out.println("当前页:"+page.getPageNum());
        System.out.println("当前页的数量:"+page.getSize());
        System.out.println("每页的数量:"+page.getPageSize());
        System.out.println("总数据量:"+page.getTotal());
    }

}

