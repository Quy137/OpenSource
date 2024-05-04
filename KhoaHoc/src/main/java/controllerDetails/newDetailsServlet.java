package controllerDetails;

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

@WebServlet("/newDetailsServlet")
public class newDetailsServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "Images";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/details/addDetails.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null; // connect SQL
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			conn = JDBCutils.getConnection();
			// xử lý tham số từ form
			String videoID = request.getParameter("videoID");
			String description = request.getParameter("description");
			String video = request.getParameter("video");
			String packagesFK = request.getParameter("packagesFK");
			

			Videodepot vd = new Videodepot (videoID, description, video, new Packages (packagesFK));


			// thêm đối tượng vào CSDL
			VideodepotDButils.insertVideodepot(vd);
			request.getRequestDispatcher("VideodepotServlet").forward(request, response);
		} catch (SQLException ex) {
			ex.printStackTrace();
			request.setAttribute("errorString", "");
			// Forward to an error page or handle the error accordingly
			request.getRequestDispatcher("/error/errorID.jsp").forward(request, response);
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}
