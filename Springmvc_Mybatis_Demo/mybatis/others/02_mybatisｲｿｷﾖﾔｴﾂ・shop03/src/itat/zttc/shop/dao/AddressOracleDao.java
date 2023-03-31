package itat.zttc.shop.dao;

import itat.zttc.shop.model.Address;

import java.util.List;

public class AddressOracleDao implements IAddressDao {

	@Override
	public void add(Address address, int userId) {

	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public Address load(int id) {
		System.out.println("oracle");
		return null;
	}

	@Override
	public List<Address> list(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
