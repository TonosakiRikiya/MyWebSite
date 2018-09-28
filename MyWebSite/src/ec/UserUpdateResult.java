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
 * Servlet implementation class UserUpdateResult
 */
@WebServlet("/UserUpdateResult")
public class UserUpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// セッション開始
		HttpSession session = request.getSession();
		try {

			// 入力フォームから受け取った値をUserDataBeansにセット
			UserDatabeans udb = new UserDatabeans();
			udb.setUpdateUserDataBeansInfo(request.getParameter("user_name_update"), request.getParameter("login_id_update"), request.getParameter("user_address_update"), (int) session.getAttribute("userId"));




				UserDAO.updateUser(udb);
				request.setAttribute("udb", udb);
				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
				dispatcher.forward(request, response);




		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
