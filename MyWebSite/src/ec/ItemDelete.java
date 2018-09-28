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
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String[] deleteItemIdList = request.getParameterValues("delete_item_id_list");
			ArrayList<ItemDatabeans> cart = (ArrayList<ItemDatabeans>) session.getAttribute("cart");

			String cartActionMessage = "";
			if (deleteItemIdList != null) {
				//削除対象の商品を削除
				for (String deleteItemId : deleteItemIdList) {
					for (ItemDatabeans cartInItem : cart) {
						if (cartInItem.getId() == Integer.parseInt(deleteItemId)) {
							cart.remove(cartInItem);
							break;
						}
					}
				}
				cartActionMessage = "削除しました";
			} else {
				cartActionMessage = "削除する商品が選択されていません";
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
