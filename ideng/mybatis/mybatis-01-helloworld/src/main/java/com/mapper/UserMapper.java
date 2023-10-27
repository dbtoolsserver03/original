package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getByUsername(@Param("userName")String userName,@Param("id")Long id);

    List<User> getByUsernameAndPassword(@Param("userName")String userName,@Param("password")String password);

    List<User> getByIdCheck(@Param("id")Long id);



    void addUser(User user);

    List<User> selectAllUser();

    User selectUserById(Map<String,Object> map);

    User selectUserByUserNameAndPassword(@Param("userName")String userName,@Param("password")String password);

    User selectUserByJavaBean(User user);

    void insertMap(Map<String,Object> map);

    void insertParam(@Param("userName")String userName,@Param("password")String password);

    void insertJavaBean(User user);

    void updateMap(Map<String,Object> map);

    void updateParam(@Param("id")Long id,@Param("userName")String userName,@Param("password")String password);


    void updateJavaBean(User user);

    void deleteMap(Map<String,Object> map);

    void deleteParam(@Param("id")Long id);

    void deleteJavaBean(User user);

    User getById(Long id);

    User getByIdLeftJoin(Long id);

    void updateUser(User user);

    List<User> foreachQuery(List<Long> ids);

    void foreachInsert(User[] users);

    List<User> bindQuery(@Param("userName")String userName,@Param("password")String password);

    List<User> cdataQuery(@Param("id")Long id);

    List<User> selectTrim(@Param("userName")String userName,@Param("password")String password);
}
