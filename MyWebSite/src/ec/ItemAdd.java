package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDatabeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAdd() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("item_id"));
			//対象のアイテム情報を取得
			ItemDatabeans item = ItemDAO.getItemByItemID(id);

			//追加した商品を表示するためリクエストパラメーターにセット
			request.setAttribute("item", item);

			//カートを取得
			ArrayList<ItemDatabeans> cart = (ArrayList<ItemDatabeans>) session.getAttribute("cart");

			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemDatabeans>();
			}
			//カートに商品を追加。
			cart.add(item);
			//カート情報更新
			session.setAttribute("cart", cart);
			request.setAttribute("cartActionMessage", "商品を追加しました");
			request.getRequestDispatcher("/WEB-INF/jsp/Cart.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
