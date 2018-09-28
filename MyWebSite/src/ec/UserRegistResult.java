package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDatabeans;
import dao.UserDAO;

/**
 * Servlet implementation class UserRegistResult
 */
@WebServlet("/UserRegistResult")
public class UserRegistResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {

			String inputUserName = request.getParameter("user_name");
			String inputUserAddress = request.getParameter("user_address");
			String inputLoginId = request.getParameter("login_id");
			String inputPassword = request.getParameter("password");
			UserDatabeans udb = new UserDatabeans();
			udb.setName(inputUserName);
			udb.setAddress(inputUserAddress);
			udb.setLoginId(inputLoginId);
			udb.setPassword(inputPassword);

				UserDAO.insertUser(udb);
				request.setAttribute("udb", udb);
				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/UserRegistrationResult.jsp");
				dispatcher.forward(request, response);



		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
