package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class UserServiceImpl implements UserService {

    @Override
    public User login(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);

        try{
            //根据用户查询用户
            User userDB = userDAO.findByUserName(user.getUsername());
            if(userDB!=null){
                if(userDB.getPassword().equals(user.getPassword())){
                    try{
                        //修改登录时间
                        userDB.setLastlogintime(new Date());
                        userDAO.update(userDB);
                        sqlSession.commit();
                        return userDB;
                    }catch (Exception e){
                        e.printStackTrace();
                        sqlSession.rollback();
                    }finally {
                        sqlSession.close();
                    }
                }
                throw new RuntimeException("密码输入错误~~~");
            }
            throw new RuntimeException("用户名输入错误~~~");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }

    }
}
