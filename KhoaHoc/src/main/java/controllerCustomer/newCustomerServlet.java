package controllerCustomer;

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

import database.CustomerDButils;
import database.JDBCutils;
import model.Customer;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
* 100)

@WebServlet("/newCustomerServlet")
public class newCustomerServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "Images";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/customer/addCustomer.jsp");
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
			String customerID = request.getParameter("customerID");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String resetPassword = request.getParameter("resetPassword");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phone");
			int phone = Integer.parseInt(phoneNumber);
			String email = request.getParameter("email");
			String dob = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(dob);
			String gender = request.getParameter("gender");
			String joinDate = request.getParameter("join");
			sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			Date join = sdf.parse(joinDate);
			Customer c = new Customer(customerID, userName, password, resetPassword,
                    name, address, phone, email, date, gender, join);

			// thêm đối tượng vào CSDL
			CustomerDButils.insertCustomer(c);
			request.getRequestDispatcher("customerServlet").forward(request, response);
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
