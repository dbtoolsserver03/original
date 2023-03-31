package itat.zttc.shop.test;


import itat.zttc.shop.dao.IAddressDao;
import itat.zttc.shop.dao.IUserDao;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.SystemContext;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.DaoUtil;

import org.junit.Before;
import org.junit.Test;

public class TestUserDao {
	private IUserDao ud;
	
	@Before
	public void init() {
		ud = (IUserDao)DaoUtil.createDaoFactory().getDao("userDao");
	}
	
	@Test
	public void testAdd(){
		User u = new User();
		u.setNickname("曹操");
		u.setPassword("123");
		u.setType(1);
		u.setUsername("cc");
		ud.add(u);
	}
	
	@Test
	public void testUpdate() {
		User u = ud.loadByUsername("cc");
		u.setPassword("2222");
		ud.update(u);
	}
	
	@Test
	public void testDelete() {
		ud.delete(110);
	}
	
	@Test
	public void testLogin() {
		User u = ud.login("wukong", "123");
		System.out.println(u.getClass().getName());
		System.out.println(u.getNickname());
	}
	
	@Test
	public void testFind() {
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(15);
		SystemContext.setOrder("desc");
		SystemContext.setSort("nickname");
		Pager<User> ps = ud.find("上");
		System.out.println(ps.getTotalRecord());
		for(User u:ps.getDatas()) {
			System.out.println(u);
		}
		
	}
	
	@Test
	public void testLoad() {
		User u = ud.load(1);
		for(Address a:u.getAddresses()) {
			System.out.println(a);
		}
	}
	
	@Test
	public void testSingle() {
		IUserDao ud1 = (IUserDao)DaoUtil.createDaoFactory().getDao("userDao");
		IUserDao ud2 = (IUserDao)DaoUtil.createDaoFactory().getDao("userDao");
		System.out.println(ud1==ud2);
		IAddressDao ad1 = (IAddressDao)DaoUtil.createDaoFactory().getDao("addressDao");
		IAddressDao ad2 = (IAddressDao)DaoUtil.createDaoFactory().getDao("addressDao");
		System.out.println(ad2==ad1);
	}

}
