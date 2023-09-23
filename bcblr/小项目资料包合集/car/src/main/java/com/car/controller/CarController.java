package com.car.controller;


import com.car.entity.Car;
import com.car.service.CarService;
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


//REST 风格编程   PostMapping  GetMapping  RestController

@RestController
@RequestMapping("/car")
@Slf4j
public class CarController {


    @Autowired
    private CarService carService;

    @Value("${photo.dir}")
    private String photoDir;

    private Map<String, Object> result = new HashMap<>();


    //更新汽车信息方法  //springboot====>  springmvc CommonsMultipartResolver +  spring
    @PostMapping("/update")
    public Map<String, Object> update(Car car, MultipartFile photo) {
        log.info("汽车信息: " + car);
        try {
            //上传文件
            if (photo!=null && photo.getSize() != 0) {
                log.info("头像信息: " + photo.getOriginalFilename());
                String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
                String fileName = UUID.randomUUID().toString() + "." + extension;
                photo.transferTo(new File(photoDir, fileName));
                car.setPath("/car/" + fileName);
            }
            carService.update(car);
            result.put("state", true);
            result.put("msg", "更新汽车信息成功,点击确定跳转至主页!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", false);
            result.put("msg", "更新失败: 更新汽车信息出错!");
        }
        return result;
    }

    //id查询汽车
    @GetMapping("/find")
    public Car find(String id) {
        return carService.find(id);
    }

    //删除汽车
    @GetMapping("/delete")
    public Map<String, Object> delete(String id) {
        log.info("删除汽车id: "+id);
        try {
            carService.delete(id);
            result.put("state", true);
            result.put("msg", "删除汽车信息成功,点击确定跳转至主页!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", false);
            result.put("msg", "删除失败: 删除汽车信息出错!");
        }
        return result;
    }

    //保存汽车
    @PostMapping("/save")
    public Map<String, Object> save(Car car, MultipartFile photo) {
        log.info("汽车信息: " + car);
        log.info("头像信息: " + photo.getOriginalFilename());
        try {
            //上传文件
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String fileName = UUID.randomUUID().toString() + "." + extension;
            photo.transferTo(new File(photoDir, fileName));
            car.setPath("/car/" + fileName);
            carService.save(car);
            result.put("state", true);
            result.put("msg", "保存汽车信息成功,点击确定跳转至主页!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", false);
            result.put("msg", "失败: 保存汽车信息出错!");
        }
        return result;
    }

    //查询所有
    @GetMapping("/findAll")
    public List<Car> findAll() {
        return carService.findAll();
    }

}
