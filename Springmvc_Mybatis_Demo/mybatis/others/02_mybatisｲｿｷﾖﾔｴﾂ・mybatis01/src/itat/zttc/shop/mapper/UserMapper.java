package itat.zttc.shop.mapper;

import itat.zttc.shop.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	/**
	 * 基于Annation的方法仅仅知道就ok
	 * @param user
	 */
	@Insert("insert into t_user (username,password,nickname,type) value (#{username},#{password},#{nickname},#{type})")
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	
	@Select("select * from t_user where id=#{id}")
	public User load(int id);
	@Select("select * from t_user")
	public List<User> list();
}
