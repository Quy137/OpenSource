package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controllerDetails.newDetailsServlet;
import model.Customer;
import model.Details;
import model.Packages;

public class DetailsDButils {
	public static List<Details> selectAllDetails(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Details> detailsList = new ArrayList<Details>();
		try {
			ps = con.prepareStatement(
					"SELECT details.*, packages.packagesID AS packagesID, packages.namePackages AS namePackages "
					+ "costPrice AS costPrice,salePrice AS salePrice"
					+ "discription AS discription,payment AS payment"
					+ "customer.customerID AS customerID,customer.userName AS userName"
					+ "customer.password AS password,customer.resetPassword AS resetPassword"
					+ "customer.name AS name,customer.address AS address"
					+ "customer.phoneNumber AS phoneNumber,customer.email AS email"
					+ "customer.dob AS dob,customer.gender AS gender ,customer.joinDate AS joinDate FROM details JOIN packages ON details.packagesID = packages.packagesID"
					+ "JOIN customer ON	details.customerID = customer.customerID;");
			rs = ps.executeQuery();
			Details d;
			while (rs.next()) {
				d = new Details (rs.getString("id"), rs.getString("image"), rs.getString("rating"),
						new Customer (rs.getString("customerID"), rs.getString("userName"),
						rs.getString("password"),rs.getString("resetPassword"),
						rs.getString("name"),rs.getString("address"),
						rs.getInt("phoneNumber"),rs.getString("email"),
						rs.getDate("dob"),rs.getString("gender"),
						rs.getDate("joinDate")),
						new Packages (rs.getString("packagesID"), rs.getString("namePackages"), rs.getDouble("costPrice")
								, rs.getDouble("salePrice"), rs.getString("discription"), rs.getString("payment")));
				detailsList.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close resources (ps, con, rs) here
		}
		return detailsList;
	}

	public static int insertDetails(Details d) throws SQLException, ClassNotFoundException {
		Connection con = null;
		int rows = 0;
		try {
			con = JDBCutils.getConnection();
			String sql = "INSERT INTO details (id, image, rating, video,customerID, packagesID) VALUES (?, ?, ?,?,?)";

			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, d.getId());
			pstm.setString(2, d.getImage());
			pstm.setString(3, d.getRating());
			System.out.println(d.getCustomerFK().getCustomerID());
			pstm.setString(4, d.getCustomerFK().getCustomerID());
			System.out.println(d.getPackagesFK().getPackagesID());
			pstm.setString(5, d.getPackagesFK().getPackagesID());
			rows = pstm.executeUpdate();
			System.out.println(rows);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return rows;
	}

	public static List<Customer> selectAllCustomer(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			ps = con.prepareStatement("select * from customer");
			rs = ps.executeQuery();
			Customer c;
			while (rs.next()) {
				c = new  Customer (rs.getString("customerID"), rs.getString("userName"),
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
	
	public static List<Packages> selectAllPackages(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Packages> packagesList = new ArrayList<Packages>();
		try {
			ps = con.prepareStatement("select * from packages");
			rs = ps.executeQuery();
			Packages p;
			while (rs.next()) {
				p = new  Packages(rs.getString("packagesID"), rs.getString("namePackages"),
						rs.getDouble("costPrice"),rs.getDouble("salePrice"),
						rs.getString("discription"),rs.getString("payment"));
				packagesList.add(p);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return packagesList;
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
				Customer c = new Customer (rs.getString("customerID"), rs.getString("userName"),
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
					Logger.getLogger(newDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static Packages findPackagesById(String packagesID) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "Select * from packages where packagesID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, packagesID);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				Packages p = new Packages(rs.getString("packagesID"), rs.getString("namePackages"),
						rs.getDouble("costPrice"),rs.getDouble("salePrice"),
						rs.getString("discription"),rs.getString("payment"));
				return p;
			}
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static Details findDetailsById(String ID) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "Select * from details where ID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, ID);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				Packages Packages = findPackagesById(rs.getString("packagesID"));
				Customer Customer = findCustomerById(rs.getString("customerID"));
				Details d = new Details (rs.getString("ID"), rs.getString("image"), rs.getString("rating"),Customer,Packages );
				return d;
			}
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static void updateDetails(Details d) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "UPDATE details SET ID=?, image=? , rating=? , customerID=? ,packagesID=? WHERE ID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, d.getId());
			pstm.setString(2, d.getImage());
			pstm.setString(3, d.getRating());
			pstm.setString(4, d.getCustomerFK().getCustomerID());
			pstm.setString(5, d.getPackagesFK().getPackagesID());
			pstm.setString(6, d.getId());
			pstm.executeUpdate();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static void deleteDetailsById(Connection con, String ID) throws SQLException {
		String sql = "delete from details where ID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, ID);
		pstm.executeUpdate();
	}
}
