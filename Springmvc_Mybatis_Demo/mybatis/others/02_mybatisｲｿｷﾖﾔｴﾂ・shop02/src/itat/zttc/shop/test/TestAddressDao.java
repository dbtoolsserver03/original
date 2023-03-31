package itat.zttc.shop.test;

import itat.zttc.shop.dao.IAddressDao;
import itat.zttc.shop.model.Address;
import itat.zttc.shop.util.DaoUtil;

import java.util.List;

import org.junit.Test;

public class TestAddressDao {
	private IAddressDao addressDao = DaoUtil.createDaoFactory().createAddressDao();
	
	
	@Test
	public void testLoad() {
		Address address = addressDao.load(1);
		System.out.println(address.getName()+","+address.getUser()+","+address.getPostcode());
	}
	
	@Test
	public void testAdd() {
		Address address = new Address();
		address.setName("云南省大理州");
		address.setPhone("114");
		address.setPostcode("652000");
		addressDao.add(address, 2);
	}
	
	@Test
	public void testList() {
		List<Address> list = addressDao.list(1);
		for(Address a:list) {
			System.out.println(a.getName()+","+a.getUser());
		}
	}
}
