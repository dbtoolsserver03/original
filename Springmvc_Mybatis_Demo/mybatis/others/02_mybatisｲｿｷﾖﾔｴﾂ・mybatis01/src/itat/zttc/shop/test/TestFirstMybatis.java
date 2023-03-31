package itat.zttc.shop.test;

import itat.zttc.shop.model.User;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestFirstMybatis {

	public static void main(String[] args) {
		testUpdate();
	}
	
	private static void testUpdate() {
		try {
			//1、创建配置文件(mybatis-config.xml)的输入流
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//2、创建SQLSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3、创建SQLSessioin
			SqlSession session = factory.openSession();
			//4、调用mapper文件插入数据（调用之前需要将mapper文件加入到mybatis-config.xml中）
			User u = new User();
			u.setNickname("孙悟空");
			u.setPassword("333");
			u.setType(0);
			u.setUsername("wukong");
			u.setId(105);
			session.update("itat.zttc.shop.model.User.update",u);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void testAdd() {
		try {
			//1、创建配置文件(mybatis-config.xml)的输入流
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//2、创建SQLSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3、创建SQLSessioin
			SqlSession session = factory.openSession();
			//4、调用mapper文件插入数据（调用之前需要将mapper文件加入到mybatis-config.xml中）
			User u = new User();
			u.setNickname("孙悟空");
			u.setPassword("123");
			u.setType(0);
			u.setUsername("wukong");
			session.insert("itat.zttc.shop.model.User.add", u);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
