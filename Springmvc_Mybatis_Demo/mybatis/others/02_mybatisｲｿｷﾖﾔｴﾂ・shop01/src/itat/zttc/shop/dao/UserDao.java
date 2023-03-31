package itat.zttc.shop.dao;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.ShopException;
import itat.zttc.shop.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public void add(User user) {
		User tu = this.loadByUsername(user.getUsername());
		if(tu!=null) throw new ShopException("要添加的用户已经存在");
		super.add(user);
	}

	@Override
	public void delete(int id) {
		//TODO 需要先删除关联对象
		super.delete(User.class, id);
	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public User loadByUsername(String username) {
		return super.loadBySqlId(User.class.getName()+".load_by_username", username);
	}

	@Override
	public User load(int id) {
		return super.load(User.class, id);
	}

	@Override
	public Pager<User> find(String name) {
		Map<String,Object> params = new HashMap<String, Object>();
		if(name!=null&&!name.equals(""))
			params.put("name", "%"+name+"%");
		return super.find(User.class, params);
	}

	@Override
	public User login(String username, String password) {
		User u = this.loadByUsername(username);
		if(u==null) throw new ShopException("用户名不存在!");
		if(!password.equals(u.getPassword())) throw new ShopException("用户名密码不正确");
		return u;
	}

}
