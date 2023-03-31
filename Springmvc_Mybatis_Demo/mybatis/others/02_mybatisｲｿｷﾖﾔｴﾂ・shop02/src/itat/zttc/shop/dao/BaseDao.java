package itat.zttc.shop.dao;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.SystemContext;
import itat.zttc.shop.util.MyBatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class BaseDao<T> {
	public void add(T obj) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.insert(obj.getClass().getName()+".add",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	public void update(T obj) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.update(obj.getClass().getName()+".update", obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	public void delete(Class<T> clz,int id) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.delete(clz.getName()+".delete", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T load(Class<T> clz,int id) {
		SqlSession session = null;
		T t = null;
		try {
			session = MyBatisUtil.createSession();
			t = (T)session.selectOne(clz.getName()+".load",id);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public T loadBySqlId(String sqlId,Map<String,Object> params) {
		SqlSession session = null;
		T t = null;
		try {
			session = MyBatisUtil.createSession();
			t = (T)session.selectOne(sqlId,params);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public T loadBySqlId(String sqlId,Object obj) {
		SqlSession session = null;
		T t = null;
		try {
			session = MyBatisUtil.createSession();
			t = (T)session.selectOne(sqlId,obj);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return t;
	}
	
	public List<T> list(Class<T> clz,Map<String,Object> params) {
		return this.list(clz.getName()+".list", params);
	}
	
	public List<T> list(String sqlId,Map<String,Object> params) {
		List<T> list = null;
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSession();
			list = session.selectList(sqlId,params);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return list;
	}
	
	public Pager<T> find(Class<T> clz,Map<String,Object> params) {
		return this.find(clz.getName()+".find", params);
	}
	
	public Pager<T> find(String sqlId,Map<String,Object> params) {
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Pager<T> pages = new Pager<T>();
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSession();
			if(params==null) params = new HashMap<String, Object>();
			params.put("pageSize", pageSize);
			params.put("pageOffset", pageOffset);
			params.put("sort", sort);
			params.put("order", order);
			List<T> datas = session.selectList(sqlId, params);
			pages.setDatas(datas);
			pages.setPageOffset(pageOffset);
			pages.setPageSize(pageSize);
			int totalRecord = session.selectOne(sqlId+"_count",params);
			pages.setTotalRecord(totalRecord);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return pages;
	}
	
}
