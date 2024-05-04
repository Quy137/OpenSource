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
import controllerVideodepot.newVideodepotServlet;
import model.Videodepot;
import model.Packages;

public class VideodepotDButils {
	public static List<Videodepot> selectAllVideodepot(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Videodepot> videodepotList = new ArrayList<Videodepot>();
		try {
			ps = con.prepareStatement(
					"SELECT videodepot.*, packages.packagesID AS packagesID, packages.namePackages AS namePackages "
					+ "costPrice AS costPrice,salePrice AS salePrice"
					+ "discription AS discription,payment AS payment FROM videodepot JOIN packages ON videodepot.packagesID = packages.packagesID");
			rs = ps.executeQuery();
			Videodepot vd;
			while (rs.next()) {
				vd = new Videodepot (rs.getString("videoID"), rs.getString("description"), rs.getString("video"),
						new Packages (rs.getString("packagesID"), rs.getString("namePackages"), rs.getDouble("costPrice")
								, rs.getDouble("salePrice"), rs.getString("discription"), rs.getString("payment")));
				videodepotList.add(vd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close resources (ps, con, rs) here
		}
		return videodepotList;
	}

	public static int insertVideodepot(Videodepot vd) throws SQLException, ClassNotFoundException {
		Connection con = null;
		int rows = 0;
		try {
			con = JDBCutils.getConnection();
			String sql = "INSERT INTO videodepot (videoID, description, video,packagesID) VALUES (?, ?, ?,?)";

			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, vd.getVideoID());
			pstm.setString(2, vd.getDescription());
			pstm.setString(3, vd.getVideo());
			System.out.println(vd.getPackagesFK().getPackagesID());
			pstm.setString(4, vd.getPackagesFK().getPackagesID());
			rows = pstm.executeUpdate();
			System.out.println(rows);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newVideodepotServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return rows;
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

	public static Videodepot findVideodepotById(String videoID) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "Select * from videodepot where videoID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, videoID);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				Packages Packages = findPackagesById(rs.getString("packagesID"));
				Videodepot vd = new Videodepot (rs.getString("videoID"), rs.getString("description"), rs.getString("video"),Packages );
				return vd;
			}
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newVideodepotServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static void updateVideodepot(Videodepot vd) throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			con = JDBCutils.getConnection();
			String sql = "UPDATE videodepot SET videoID=?, description=? , video=? , packagesID=? WHERE videoID=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, vd.getVideoID());
			pstm.setString(2, vd.getDescription());
			pstm.setString(3, vd.getVideo());
			pstm.setString(4, vd.getPackagesFK().getPackagesID());
			pstm.setString(5, vd.getVideoID());
			pstm.executeUpdate();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(newVideodepotServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public static void deleteVideodepotById(Connection con, String videoID) throws SQLException {
		String sql = "delete from videodepot where videoID=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, videoID);
		pstm.executeUpdate();
	}
}
