package itat.zttc.shop.dao;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.User;

public class UserOracleDao implements IUserDao {

	@Override
	public void add(User user) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User load(int id) {
		System.out.println("oracle");
		return null;
	}

	@Override
	public Pager<User> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
