package itat.zttc.shop.util;

import itat.zttc.shop.dao.IFactoryDao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DaoUtil {
	public static void main(String[] args) {
		System.out.println(createDaoFactory());
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IFactoryDao createDaoFactory() {
		IFactoryDao f = null;
		try {
			Properties prop = PropertiesUtil.getDaoProp();
			String fs = prop.getProperty("factory");
			Class clz = Class.forName(fs);
			String mn = "getInstance";
			Method m = clz.getMethod(mn);
			f = (IFactoryDao)m.invoke(clz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return f;
	}
}
