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

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//入力内容に誤りがある、確認画面で戻るボタン押し下げでアクセスしてきたときはセッションから入力情報を取得
		UserDatabeans udb = session.getAttribute("udb") != null?(UserDatabeans) EcHelper.cutSessionAttribute(session, "udb"):new UserDatabeans();
		String validationMessage = (String) EcHelper.cutSessionAttribute(session, "validationMessage");

		request.setAttribute("udb", udb);
		request.setAttribute("validationMessage",validationMessage);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp");
		dispatcher.forward(request, response);
	}



}
