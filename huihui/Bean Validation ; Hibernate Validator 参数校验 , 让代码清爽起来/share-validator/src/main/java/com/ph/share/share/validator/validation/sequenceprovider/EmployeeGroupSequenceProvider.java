package com.ph.share.share.validator.validation.sequenceprovider;

import com.ph.share.share.validator.entity.Employee;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class EmployeeGroupSequenceProvider implements DefaultGroupSequenceProvider<Employee> {

    /**
     * 举例
     * 1、员工的 age 在 20-25 之间，title 必须以 "初级" 开头
     * 2、员工的 age 在 25-30 之间，title 必须以 "中级" 开头
     * 3、否则，不做验证
     */

    @Override
    public List<Class<?>> getValidationGroups(Employee employee) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(Employee.class);//  相当于添加了默认组 javax.validation.groups.Default


        if ( employee != null ) {
            if (20 < employee.getAge() && employee.getAge() <= 25) {
                defaultGroupSequence.add(Employee.TitleJunior.class);
            } else if (25 < employee.getAge() && employee.getAge() <= 30) {
                defaultGroupSequence.add(Employee.TitleMiddle.class);
            }
        }

        return defaultGroupSequence;
    }
}
