package com.baizhiedu.service;

import com.baizhiedu.dao.UserDAO;
import com.baizhiedu.entity.User;

//@Transactional(rollbackFor = {java.lang.Exception.class},noRollbackFor = {java.lang.RuntimeException.class})
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) throws Exception{
        userDAO.save(user);
        //throw new RuntimeException("测试");
        //throw new Exception("测试2");
    }

    @Override
    //@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(String name, String password) {

    }
}
