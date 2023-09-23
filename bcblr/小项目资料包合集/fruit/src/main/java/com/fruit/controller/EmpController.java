package com.fruit.controller;


import com.fruit.entity.Emp;
import com.fruit.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {


    @Autowired
    private EmpService empService;

    @Value("${photo.dir}")
    private String photoDir;

    private Map<String, Object> result = new HashMap<>();


    //更新水果信息方法
    @PostMapping("/update")
    public Map<String, Object> update(Emp emp, MultipartFile photo) {
        log.info("水果信息: " + emp);
        try {
            //上传文件
            if (photo!=null && photo.getSize() != 0) {
                log.info("头像信息: " + photo.getOriginalFilename());
                String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
                String fileName = UUID.randomUUID().toString() + "." + extension;
                photo.transferTo(new File(photoDir, fileName));
                emp.setPath("/fruit/" + fileName);
            }
            empService.update(emp);
            result.put("state", true);
            result.put("msg", "更新水果信息成功,点击确定跳转至主页!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", false);
            result.put("msg", "更新失败: 更新水果信息出错!");
        }
        return result;
    }

    //id查询水果
    @GetMapping("/find")
    public Emp find(String id) {
        return empService.find(id);
    }

    //删除水果
    @GetMapping("/delete")
    public Map<String, Object> delete(String id) {
        log.info("删除水果id: "+id);
        try {
            empService.delete(id);
            result.put("state", true);
            result.put("msg", "删除水果信息成功,点击确定跳转至主页!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", false);
            result.put("msg", "删除失败: 删除水果信息出错!");
        }
        return result;
    }

    //保存水果
    @PostMapping("/save")
    public Map<String, Object> save(Emp emp, MultipartFile photo) {
        log.info("水果信息: " + emp);
        log.info("头像信息: " + photo.getOriginalFilename());
        try {
            //上传文件
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String fileName = UUID.randomUUID().toString() + "." + extension;
            photo.transferTo(new File(photoDir, fileName));
            emp.setPath("/fruit/" + fileName);
            empService.save(emp);
            result.put("state", true);
            result.put("msg", "保存水果信息成功,点击确定跳转至主页!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", false);
            result.put("msg", "失败: 保存水果信息出错!");
        }
        return result;
    }

    //查询所有
    @GetMapping("/findAll")
    public List<Emp> findAll() {
        return empService.findAll();
    }

}
