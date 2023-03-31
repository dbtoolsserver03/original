package itat.zttc.shop.dao;

public class MysqlDaoFactory implements IFactoryDao {
	private static IFactoryDao factory = new MysqlDaoFactory();
	private MysqlDaoFactory() {	}
	
	public static IFactoryDao getInstance() {
		return factory;
	}
	
	@Override
	public IAddressDao createAddressDao() {
		return new AddressDao();
	}

	@Override
	public IUserDao createUserDao() {
		return new UserDao();
	}
}
