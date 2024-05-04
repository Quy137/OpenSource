package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controllerPackages.newPackagesServlet;
import model.Packages;


public class PackagesDButils {
	public static List<Packages> selectAllPackages(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Packages> packagesList = new ArrayList<Packages>();
		try {
			ps = con.prepareStatement("select * from customer");
			rs = ps.executeQuery();
			Packages p;
			while (rs.next()) {
				p = new Packages(rs.getString("packagesID"), rs.getString("namePackages"),
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
					Logger.getLogger(newPackagesServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static int insertPackages(Packages packages) throws SQLException, ClassNotFoundException {
		Connection con = null;
		int rows = 0;
		try {
			con = JDBCutils.getConnection();
			String sql = "INSERT INTO packages (packagesID,namePackages,costPrice,salePrice,discription,payment VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, packages.getPackagesID());
			pstm.setString(2, packages.getNamePackages());
			pstm.setDouble(3, packages.getCostPrice());
			pstm.setDouble(4, packages.getSalePrice());
			pstm.setString(5, packages.getDiscription());
			pstm.setString(6, packages.getPayment());
			rows = pstm.executeUpdate();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newPackagesServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return rows;
	}

	public static void updatePackages(Packages packages) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "UPDATE packages SET packagesID =?, namePackages=?, costPrice=?, salePrice=?, discription=?, payment=? WHERE packagesID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, packages.getPackagesID());
			pstm.setString(2, packages.getNamePackages());
			pstm.setDouble(3, packages.getCostPrice());
			pstm.setDouble(4, packages.getSalePrice());
			pstm.setString(5, packages.getDiscription());
			pstm.setString(6, packages.getPayment());
			pstm.executeUpdate();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newPackagesServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static void deletePackagesById(Connection con, String packagesID) throws SQLException {
		String sql = "delete from packages where packagesID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, packagesID);
		pstm.executeUpdate();
	}
}
