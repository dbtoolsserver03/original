package itat.zttc.shop.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties jdbcProp;
	private static Properties daoProp;
	
	public static Properties getJdbcProp() {
		try {
			if(jdbcProp==null) {
				jdbcProp = new Properties();
				jdbcProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jdbcProp;
	}
	
	public static Properties getDaoProp() {
		try {
			if(daoProp==null) {
				daoProp = new Properties();
				daoProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("dao.properties"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return daoProp;
	}
}
