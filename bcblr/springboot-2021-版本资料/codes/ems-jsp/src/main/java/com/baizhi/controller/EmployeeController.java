package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用来开发员工相关功能
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * 根据id删除员工信息
     * @return
     */
    @RequestMapping("/delete")
    public String deleteEmployee(Integer id){
        log.debug("删除的id: {}",id);
        //1.根据id删除员工信息
        employeeService.delete(id);
        //2.跳转到列表页面
        return "redirect:/employee/list";
    }

    /**
     * 更新员工信息
     *
     * @return
     */
    @RequestMapping("update")
    public String updateEmployee(Employee employee) {
        log.debug("员工id: {}", employee.getId());
        log.debug("员工名称: {}", employee.getName());
        log.debug("员工工资: {}", employee.getSalary());
        log.debug("员工生日: {}", employee.getBirthday());
        log.debug("员工性别: {}", employee.getGender());
        //1.更新员工信息
        employeeService.update(employee);
        //2.跳转到员工列表
        return "redirect:/employee/list";
    }

    /**
     * 根据id查询员工信息
     *
     * @return
     */
    @RequestMapping("detail")
    public String detailEmployee(Integer id, Model model) {
        log.debug("接收id: {}", id);
        //1.根据id查询一个员工
        Employee employee = employeeService.idByEmployee(id);
        //2.存入作用域request session application
        model.addAttribute("employee", employee);
        return "updateEmp";//跳转页面
    }


    /**
     * 添加员工信息
     *
     * @return
     */
    @RequestMapping("add")
    public String addEmployee(Employee employee) {
        log.debug("员工名称: {}", employee.getName());
        log.debug("员工工资: {}", employee.getSalary());
        log.debug("员工生日: {}", employee.getBirthday());
        log.debug("员工性别: {}", employee.getGender());
        //1.保存员工信息
        employeeService.add(employee);
        return "redirect:/employee/list";//跳转到列表
    }

    /**
     * 员工列表
     *
     * @return
     */
    @RequestMapping("list")
    public String listEmployee(HttpServletRequest request, Model model) {
        //1.获取员工列表
        List<Employee> employees = employeeService.list();
        //request.setAttribute("employees",employees);
        model.addAttribute("employees", employees);
        return "emplist";
    }
}
