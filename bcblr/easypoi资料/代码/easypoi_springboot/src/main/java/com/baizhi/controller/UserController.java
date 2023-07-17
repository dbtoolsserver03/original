package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @Value("${upload.dir}")
    private String realPath;

    //导出Excel
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        //查询数据库查询所有数据
        List<User> users = userService.findAll();
        users.forEach(user -> {
            user.setPhoto(realPath+"/"+user.getPhoto());
        });
        log.info("导出Excel,当前数据库中数据总数为: [{}]",users.size());
        //生成excel
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户列表信息", "用户信息"), User.class, users);
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    //导入Excel文件
    @RequestMapping("/import")
    public String importExcel(MultipartFile excelFile) throws Exception {
        log.info("文件名: [{}]",excelFile.getOriginalFilename());

        //excel导入
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<User> users = ExcelImportUtil.importExcel(excelFile.getInputStream(), User.class, params);
        //users.forEach(System.out::println);
        userService.saveAll(users);
        return "redirect:/user/findAll";//上传完成之后,跳转到查询所有信息路径
    }

    //查询所有
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "index";
    }
}
