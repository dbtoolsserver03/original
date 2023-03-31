package itat.zttc.shop.test;


import itat.zttc.shop.model.User;
import itat.zttc.shop.util.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMyBatis {

	@Test
	public void testDelete() {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory f = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = f.openSession();
			session.delete(User.class.getName()+".delete",105);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User u = new User();
			u.setNickname("孙悟空");
			u.setPassword("123");
			u.setType(1);
			u.setUsername("wukong");
			session.insert(User.class.getName()+".add", u);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testLoad() {
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSession();
			User u = (User)session.selectOne(User.class.getName()+".load", 1);
			System.out.println(u.getNickname());
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testList() {
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSession();
			List<User> us = session.selectList(User.class.getName()+".list", null);
			System.out.println(us.size());
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
}
