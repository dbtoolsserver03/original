package com.ph.share.share.validator.service;


import com.ph.share.share.validator.entity.Employee;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public interface IEmployeeService {
    void add(@Valid Employee employee);

    @NotNull Employee getById(@NotNull Integer id);
}
