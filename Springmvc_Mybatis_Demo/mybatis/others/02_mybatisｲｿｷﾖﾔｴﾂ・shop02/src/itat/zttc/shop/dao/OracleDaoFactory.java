package itat.zttc.shop.dao;

public class OracleDaoFactory implements IFactoryDao {
	private static IFactoryDao f = new OracleDaoFactory();
	private OracleDaoFactory(){}

	public static IFactoryDao getInstance() {
		return f;
	}
	@Override
	public IUserDao createUserDao() {
		return new UserOracleDao();
	}

	@Override
	public IAddressDao createAddressDao() {
		return new AddressOracleDao();
	}

}
