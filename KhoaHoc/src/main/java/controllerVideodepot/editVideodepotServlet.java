package controllerVideodepot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCutils;
import database.PackagesDButils;
import database.VideodepotDButils;
import model.Packages;
import model.Videodepot;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
* 100)

@WebServlet("/editVideodepotServlet")
public class editVideodepotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editVideodepotServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String errorString = null;
		String id = request.getParameter("videoID");
		Videodepot videodepot = new Videodepot();
		try {
			Connection con = JDBCutils.getConnection();
			videodepot = VideodepotDButils.findVideodepotById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("updateVideodepot", videodepot);
		request.getRequestDispatcher("/videodepot/updateVideodepot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null; // connect SQL
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			con = JDBCutils.getConnection();
			String videoID = request.getParameter("videoID");
			String description = request.getParameter("description");
			String video = request.getParameter("video");
			String packagesFK = request.getParameter("packagesFK");
			

			Videodepot vd = new Videodepot (videoID, description, video, new Packages (packagesFK));

			VideodepotDButils.updateVideodepot(vd);
			request.getRequestDispatcher("videodepotServlet").forward(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		// doGet(request, response);
	}
}
