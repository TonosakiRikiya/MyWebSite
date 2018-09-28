package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeliveryMethodDatabeans;
import beans.ItemDatabeans;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class Buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {

			Boolean isLogin = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin") : false;
			ArrayList<ItemDatabeans> cart = (ArrayList<ItemDatabeans>) session.getAttribute("cart");

			if (!isLogin) {
				// Sessionにリターンページ情報を書き込む
				session.setAttribute("returnStrUrl", "Buy");
				// Login画面にリダイレクト
				response.sendRedirect("UserLogin");

			} else if (cart.size() == 0) {
				request.setAttribute("cartActionMessage", "購入する商品がありません");
				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/Cart.jsp");
				dispatcher.forward(request, response);
			} else {
				// 配送方法をDBから取得
				ArrayList<DeliveryMethodDatabeans> dMDBList = DeliveryMethodDAO.getAllDeliveryMethodDataBeans();
				request.setAttribute("dmdbList", dMDBList);
				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/Buy.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
