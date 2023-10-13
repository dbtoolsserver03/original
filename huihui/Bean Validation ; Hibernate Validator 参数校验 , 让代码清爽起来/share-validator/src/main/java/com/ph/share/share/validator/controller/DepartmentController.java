package com.ph.share.share.validator.controller;


import com.ph.share.share.validator.entity.Department;
import com.ph.share.share.validator.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/department")
@Validated  //对本类中的方法开启参数验证功能
public class DepartmentController {

//    @Autowired
//    private DepartmentService departmentService;
    /**
     *
     * http://localhost:8080/department
     * 添加部门
     * addRoot  parent_id=0
     * add
     *
     * @param department 要添加的部门
     * @return
     */
    @PostMapping
    public ResultVO add(@RequestBody @Valid /*校验后面的参数*/ Department department) {

        //终于可以开始 写业务了
//        departmentService.add(department);
        return ResultVO.success();
    }


}
