package com.ph.share.share.validator.service.impl;

import com.ph.share.share.validator.entity.Employee;
import com.ph.share.share.validator.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Service
@Validated
public class EmployeeService implements IEmployeeService {
    @Override
    public void add(Employee employee) {
        // 业务逻辑
        System.out.println("员工添加成功");
    }

    @Override
    public @NotNull Employee getById(@NotNull Integer id) {
        return null;
    }
}
