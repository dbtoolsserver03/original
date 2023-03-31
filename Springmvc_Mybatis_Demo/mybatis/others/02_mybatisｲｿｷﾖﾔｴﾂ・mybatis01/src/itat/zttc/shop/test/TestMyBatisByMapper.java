package itat.zttc.shop.test;


import java.util.List;

import itat.zttc.shop.mapper.UserMapper;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMyBatisByMapper {

	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			User u = new User();
			u.setNickname("猪八戒");
			u.setPassword("222");
			u.setType(1);
			u.setUsername("bajie");
			session.getMapper(UserMapper.class).add(u);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	@Test
	public void testList() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			List<User> us = session.getMapper(UserMapper.class).list();
			System.out.println(us.size());
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

}
