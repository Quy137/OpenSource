package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controllerCustomer.newCustomerServlet;
import model.Customer;

public class CustomerDButils {
	public static List<Customer> selectAllCustomer(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			ps = con.prepareStatement("select * from customer");
			rs = ps.executeQuery();
			Customer c;
			while (rs.next()) {
				c = new Customer(rs.getString("customerID"), rs.getString("userName"),
						rs.getString("password"),rs.getString("resetPassword"),
						rs.getString("name"),rs.getString("address"),
						rs.getInt("phoneNumber"),rs.getString("email"),
						rs.getDate("dob"),rs.getString("gender"),
						rs.getDate("joinDate"));
				
				customerList.add(c);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return customerList;
	}

	public static Customer findCustomerById(String customerID) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "Select * from customer where customerID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, customerID);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				Customer c = new Customer(rs.getString("customerID"), rs.getString("userName"),
						rs.getString("password"),rs.getString("resetPassword"),
						rs.getString("name"),rs.getString("address"),
						rs.getInt("phoneNumber"),rs.getString("email"),
						rs.getDate("dob"),rs.getString("gender"),
						rs.getDate("joinDate"));
				return c;
			}
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static int insertCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		Connection con = null;
		int rows = 0;
		try {
			con = JDBCutils.getConnection();
			String sql = "INSERT INTO customer (customerID, userName, password, resetPassword, name, address, phoneNumber, email, dob, gender, joinDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, customer.getCustomerID());
			pstm.setString(2, customer.getUserName());
			pstm.setString(3, customer.getPassword());
			pstm.setString(4, customer.getName());
			pstm.setString(5, customer.getAddress());
			pstm.setInt(6, customer.getPhoneNumber());
			pstm.setString(7, customer.getEmail());
			pstm.setDate(8, (Date) customer.getDob());
			pstm.setString(9, customer.getGender());
			pstm.setDate(10, (Date) customer.getJoinDate());
			rows = pstm.executeUpdate();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return rows;
	}

	public static void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "UPDATE customer SET customerID =?, userName=?, password=?, resetPassword=?, name=?, address=?, phoneNumber=?, email=?, dob=?, gender=?, joinDate=? WHERE customerID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, customer.getCustomerID());
			pstm.setString(2, customer.getUserName());
			pstm.setString(3, customer.getPassword());
			pstm.setString(4, customer.getName());
			pstm.setString(5, customer.getAddress());
			pstm.setInt(6, customer.getPhoneNumber());
			pstm.setString(7, customer.getEmail());
			pstm.setDate(8, (Date) customer.getDob());
			pstm.setString(9, customer.getGender());
			pstm.setDate(10, (Date) customer.getJoinDate());
			pstm.executeUpdate();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static void deleteCustomerById(Connection con, String customerID) throws SQLException {
		String sql = "delete from customer where customerID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, customerID);
		pstm.executeUpdate();
	}
}
