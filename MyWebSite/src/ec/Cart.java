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

import beans.ItemDatabeans;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
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
			ArrayList<ItemDatabeans> cart = (ArrayList<ItemDatabeans>) session.getAttribute("cart");
			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemDatabeans>();
				session.setAttribute("cart", cart);
			}

			String cartActionMessage = "";
			//カートに商品が入っていないなら
			if(cart.size() == 0) {
				cartActionMessage = "カートに商品がありません";
			}

			request.setAttribute("cartActionMessage", cartActionMessage);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/Cart.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}

