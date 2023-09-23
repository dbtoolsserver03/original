package com.baizhiedu.injection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
   /* @Autowired
    @Qualifier("userDAOImpl")*/

    //@Resource(name="userDAOImpl")
    @Resource
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

/*    @Autowired
    @Qualifier("userDAOImpl")*/
    public void setUserDAO(UserDAO userDAO) {
        System.out.println("UserServiceImpl.setUserDAO");
        this.userDAO = userDAO;
    }

    @Override
    public void register() {
        userDAO.save();
    }
}
