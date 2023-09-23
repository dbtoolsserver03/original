package com.baizhi.service;

import com.baizhi.dao.DeptDAO;
import com.baizhi.entity.Dept;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class DeptServiceImpl implements DeptService {


    @Override
    public void save(Dept dept) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);
        try {
            //处理业务
            dept.setUptime(new Date()); //设置成立时间
            dept.setNumbers("0");//设置部门成员个数
            deptDAO.save(dept);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Dept> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);
        List<Dept> depts;
        try {
            depts = deptDAO.findAll();
        } finally {
            sqlSession.close();
        }
        return depts;
    }
}
