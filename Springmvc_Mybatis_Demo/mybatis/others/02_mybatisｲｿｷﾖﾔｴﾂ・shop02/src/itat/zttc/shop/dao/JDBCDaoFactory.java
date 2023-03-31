package itat.zttc.shop.dao;

public class JDBCDaoFactory implements IFactoryDao {
	private static JDBCDaoFactory factory = new JDBCDaoFactory();
	/*
	 * 限制new
	 */
	private JDBCDaoFactory(){}
	
	public static IFactoryDao getInstance() {
		return factory;
	}

	@Override
	public IUserDao createUserDao() {
		return new UserJDBCDao();
	}

	@Override
	public IAddressDao createAddressDao() {
		return new AddressJDBCDao();
	}

}
