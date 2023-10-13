package com.ph.share.share.validator.controller;


import com.ph.share.share.validator.entity.Employee;
import com.ph.share.share.validator.validation.ValidList;
import com.ph.share.share.validator.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.groups.Default;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;

    @PostMapping
    public ResultVO add(@RequestBody @Validated({Employee.Add.class, Default.class}) Employee employee) {
//        employeeService.add(employee);

        return ResultVO.success();
    }

    @PostMapping("/list")
    public ResultVO addList(@RequestBody @ValidList(groupings = {Employee.Add.class, Default.class}, quickFail = true)
                                    List<Employee> employeeList) {
        return ResultVO.success();
    }

//    @PutMapping
//    public ResultVO update(@RequestBody @Validated({Employee.Update.class, Default.class}) Employee employee) {
//        return ResultVO.success();
//    }

    @PutMapping
    public ResultVO update(@RequestBody @Valid Employee employee) {
        return ResultVO.success();
    }

    @GetMapping
    public ResultVO add(@RequestBody @Min(10) Integer id) {
//        employeeService.getById(id);
        return ResultVO.success();
    }
}
