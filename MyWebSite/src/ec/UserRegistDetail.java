package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDatabeans;
import dao.UserDAO;

/**
 * Servlet implementation class UserRegistDetail
 */
@WebServlet("/UserRegistDetail")
public class UserRegistDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistDetail() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
			String inputConfirmPassword = request.getParameter("confirm_password");

			UserDatabeans udb = new UserDatabeans();
			udb.setName(inputUserName);
			udb.setAddress(inputUserAddress);
			udb.setLoginId(inputLoginId);
			udb.setPassword(inputPassword);

			String validationMessage = "";

			// 入力されているパスワードが確認用と等しいか
			if (!inputPassword.equals(inputConfirmPassword)) {
				validationMessage += "入力されているパスワードと確認用パスワードが違います<br>";
			}

			// ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
			if (!EcHelper.isLoginIdValidation(udb.getLoginId())) {
				validationMessage += "半角英数とハイフン、アンダースコアのみ入力できます";
			}
			// loginIdの重複をチェック
			if (UserDAO.isOverlapLoginId(udb.getLoginId(), 0)) {
				validationMessage += "ほかのユーザーが使用中のログインIDです";
			}

			// バリデーションエラーメッセージがないなら確認画面へ
			if (validationMessage.length() == 0) {
				request.setAttribute("udb", udb);
				request.getRequestDispatcher("/WEB-INF/jsp/UserRegistrationConfo.jsp").forward(request, response);
			} else {
				session.setAttribute("udb", udb);
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("UserRegistration");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
