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

@WebServlet("/editCustomerServlet")
public class editCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editCustomerServlet() {
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
		String id = request.getParameter("customerID");
		Customer customer = new Customer();
		try {
			Connection con = JDBCutils.getConnection();
			customer = CustomerDButils.findCustomerById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("updateCustomer", customer);
		request.getRequestDispatcher("/customer/updateCustomer.jsp").forward(request, response);
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

			CustomerDButils.updateCustomer(c);
			request.getRequestDispatcher("customerServlet").forward(request, response);
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
