package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类(Category)表控制层
 *
 * @author makejava
 * @since 2021-07-15 17:08:34
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //删除类别
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("删除类别id: {}", id);
        categoryService.deleteById(id);
    }

    //添加类别接口
    @PostMapping  //{name:"xxx","parent_id":1}
    public Category save(@RequestBody Category category) {
        log.info("添加类别信息: {}", JSONUtils.writeJSON(category));
        category = categoryService.insert(category);
        log.info("添加之后类别信息: {}", JSONUtils.writeJSON(category));
        return category;
    }

    //修改列表接口
    @PatchMapping("/{id}")  //{"name":"","parent_id":..}
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
        log.info("更新类别id: {}", id);
        log.info("更新类别信息: {}", JSONUtils.writeJSON(category));
        //1.更新
        category.setId(id);
        return categoryService.update(category);
    }

    //类别列表
    @GetMapping
    public List<Category> categories() {
        return categoryService.queryByFirstLevel();
    }
}
