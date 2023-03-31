package itat.zttc.shop.dao;

import itat.zttc.shop.util.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesFactory implements IFactoryDao {
	private static PropertiesFactory f = new PropertiesFactory();
	private static Map<String,Object> daos = new HashMap<String, Object>();
	private PropertiesFactory() {	}
	public static IFactoryDao getInstance() {
		return f;
	}
	@Override
	public Object getDao(String name) {
		try {
			if(daos.containsKey(name)){
				return daos.get(name);
			}
			Properties prop = PropertiesUtil.getDaoProp();
			String cn = prop.getProperty(name);
			Object obj = Class.forName(cn).newInstance();
			daos.put(name, obj);
			return obj;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
