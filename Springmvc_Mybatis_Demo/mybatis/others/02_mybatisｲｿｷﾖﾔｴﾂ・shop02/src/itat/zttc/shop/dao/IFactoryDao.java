package itat.zttc.shop.dao;

public interface IFactoryDao {
	public IUserDao createUserDao();
	public IAddressDao createAddressDao();
}
