package com.boot.mapper;

import com.boot.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

//@Mapper:这是给Spring扫描的 Spring会扫描到生成UserMapper的bean对象
@Mapper
public interface UserMapper {

    List<User> list();

    void deleteById(@Param("id")Long id);

    List<User> pages(@Param("start")Integer start,@Param("pageSize")Integer pageSize);

    @Insert("insert into t_user(addTime,userName,password) values(#{addTime},#{userName},#{password})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", resultType = Long.class,before = false)
    int insert(User user);

    @Select("select * from t_user")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="addTime", property="addTime", jdbcType= JdbcType.TIMESTAMP),
            @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
            @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
            @Result(property="address",column="address_id",one=@One(select="com.boot.mapper.AddressMapper.getById"))
    })
    List<User> queryAllUser();

    @Insert("insert into t_user(userName,password,age,sex) values(#{userName},#{password},#{age},#{sex})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", resultType = Long.class,before = false)
    public int insert2(User user);

    @Update("update t_user set addTime=#{addTime}, userName= #{userName}, password = #{password} where id = #{id}")
    void updateUserById(User user);

    @Delete("delete from  t_user  where id =#{id} or userName=#{userName}")
    void delById(Long id,String userName);

    @Select("select id, addTime,userName,password,age,sex from t_user where id = #{id}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="addTime", property="addTime", jdbcType= JdbcType.TIMESTAMP),
            @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
            @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
            @Result(property="menus", column="id", many=@Many(select="com.boot.mapper.MenuMapper.selectByUserId"))
    })
    User getUserById(Long id);

    List<User> listAll();

    void addUser(User user);

}

