package com.baizhi.service;

import com.baizhi.dao.DeptDAO;
import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {


    @Override
    public void update(Emp emp) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);
        // 接收到员工信息中部门存在两种情况:  a.部门变化  b.部门没有变化
        try{
            //1.根据员工id查询员工的原始部门
            Emp source = empDAO.findOne(emp.getId());
            //部门变化
            if(!source.getDeptid().equals(emp.getDeptid())){
                //1.部门发生变化(更新原始部门人数 新部门人数)
                //2.原始所在部门人员-1
                Dept oldDept = deptDAO.findOne(source.getDeptid());
                oldDept.setNumbers(String.valueOf(Integer.valueOf(oldDept.getNumbers())-1));
                deptDAO.update(oldDept);
                //3.变化之后的部门人员+1
                Dept newDept = deptDAO.findOne(emp.getDeptid());
                newDept.setNumbers(String.valueOf(Integer.valueOf(newDept.getNumbers())+1));
                deptDAO.update(newDept);
            }
            empDAO.update(emp);//更新员工信息
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public Emp findOne(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        Emp emp;
        try {
            emp = empDAO.findOne(id);
        } finally {
            sqlSession.close();
        }
        return emp;
    }

    @Override
    public void delete(String id) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);

        try {
            //1.根据删除id查询员工的信息
            Emp emp = empDAO.findOne(id);
            //2.根据员工所在部门查询部门信息并修改部门人数
            Dept dept = deptDAO.findOne(emp.getDeptid());
            dept.setNumbers(String.valueOf(Integer.valueOf(dept.getNumbers()) - 1));
            deptDAO.update(dept);
            //3.删除员工信息
            empDAO.delete(id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }

    @Override
    public void save(Emp emp) {
        //控制事务 处理业务 调用DAO
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        try{
            //向当前emp中deptid对应的部门加入一个新的员工
            empDAO.save(emp);
            //更新当前emp所在部门的人员总数
            Dept dept = deptDAO.findOne(emp.getDeptid());
            //变化部门对象人员个数+1
            dept.setNumbers(String.valueOf(Integer.valueOf(dept.getNumbers())+1));
            //更新部门到数据库
            deptDAO.update(dept);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Emp> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        List<Emp> emps;
        try {
            emps = empDAO.findAll();
        } finally {
            sqlSession.close();
        }
        return emps;
    }
}
