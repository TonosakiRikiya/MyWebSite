package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//ログイン失敗時に使用するため
		String inputLoginId =session.getAttribute("loginId")!=null?(String) EcHelper.cutSessionAttribute(session,"loginId"):"";
		String loginErrorMessage = (String)EcHelper.cutSessionAttribute(session, "loginErrorMessage");

		request.setAttribute("inputLoginId", inputLoginId);
		request.setAttribute("loginErrorMessage", loginErrorMessage);

		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/UserLogin.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {
			//パラメーターから取得
			String loginId = request.getParameter("loginId");
			String password = request.getParameter("password");

			//ユーザーIDを取得
			int userId = UserDAO.getUserId(loginId, password);

			//ユーザーIDが取得できたなら
			if (userId != 0) {
				session.setAttribute("isLogin", true);
				session.setAttribute("userId", userId);
				//ログイン前のページを取得
				String returnStrUrl = (String) EcHelper.cutSessionAttribute(session, "returnStrUrl");

				response.sendRedirect(returnStrUrl!=null?returnStrUrl:"UserDetail");
			} else {
				session.setAttribute("loginId", loginId);
				session.setAttribute("loginErrorMessage", "入力内容が正しくありません");
				response.sendRedirect("UserLogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}


	}
}