package itat.zttc.shop.dao;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.User;

public interface IUserDao {
	public void add(User user);
	public void delete(int id);
	public void update(User user);
	public User loadByUsername(String username);
	public User load(int id);
	public Pager<User> find(String name);
	public User login(String username,String password);
}
