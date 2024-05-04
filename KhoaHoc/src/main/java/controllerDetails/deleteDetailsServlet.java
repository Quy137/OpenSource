package controllerDetails;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DetailsDButils;
import database.JDBCutils;
@WebServlet("/deleteDetailsServlet")
public class deleteDetailsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			con = JDBCutils.getConnection();

			// Get the ID value from the request
			String ID = request.getParameter("ID");

			// Call the deleteKhoaById method from khoaDButils
			DetailsDButils.deleteDetailsById(con, ID);

			// Redirect to the page displaying the list after deletion
			response.sendRedirect(request.getContextPath() + "/detailsServlet");
		} catch (SQLException ex) {
			ex.printStackTrace();
			request.setAttribute("errorString", "");
			// Forward to an error page or handle the error accordingly
			request.getRequestDispatcher("/error/errorPage.jsp").forward(request, response);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					// Handle closing connection error if needed
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("detailsServlet").forward(request, response);
	}
}
