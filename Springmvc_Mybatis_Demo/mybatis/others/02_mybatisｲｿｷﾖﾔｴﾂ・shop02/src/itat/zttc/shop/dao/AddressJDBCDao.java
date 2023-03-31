package itat.zttc.shop.dao;

import itat.zttc.shop.model.Address;
import itat.zttc.shop.model.User;
import itat.zttc.shop.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressJDBCDao implements IAddressDao {

	@Override
	public void add(Address address, int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into t_address(name,phone,postcode,user_id) value (?,?,?,?)";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getName());
			ps.setString(2, address.getPhone());
			ps.setString(3, address.getPostcode());
			ps.setInt(4, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Address address) {

	}

	@Override
	public void delete(int id) {

	}


	@Override
	public List<Address> list(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Address> as = new ArrayList<Address>();
		Address a = null;
		User u = null;
		try {
			String sql = "select t1.id as 'a_id',t1.name as 'a_name',t1.phone as 'phone'," +
					" t1.postcode,t2.id as 'user_id',t2.nickname,t2.password,t2.username," +
					"t2.type as 'user_type' from t_address t1 left join t_user t2 on(t1.user_id=t2.id) where user_id=?";
			//sql = "select t1.*,t2.*,t1.id as 'a_id from xxx'"
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				a = new Address();
				a.setId(rs.getInt("a_id"));
				a.setName(rs.getString("a_name"));
				a.setPhone(rs.getString("phone"));
				a.setPostcode(rs.getString("postcode"));
				u = new User();
				u.setId(rs.getInt("user_id"));
				u.setNickname(rs.getString("nickname"));
				u.setPassword(rs.getString("password"));
				u.setType(rs.getInt("user_type"));
				u.setUsername(rs.getString("username"));
				a.setUser(u);
				as.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return as;
	}

	@Override
	public Address load(int id) {
		System.out.println("jdbc");
		return null;
	}

}
