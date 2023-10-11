package com.baizhi.test;

import com.baizhi.utils.VerifyCodeUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VerifyCodeTests {

    @Test
    public void testGenerate() throws IOException {
        String s = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println(s);
        //写入图片
        FileOutputStream os = new FileOutputStream(new File("/Users/chenyn/Desktop/线上课/项目阶段/01springboot/codes/ems-jsp/aa.png"));
        VerifyCodeUtils.outputImage(220,80,os,s);

    }
}
