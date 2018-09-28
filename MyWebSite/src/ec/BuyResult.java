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

import beans.BuyDatabeans;
import beans.BuyDetailDatabeans;
import beans.ItemDatabeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class BuyResult
 */
@WebServlet("/BuyResult")
public class BuyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {

			// セッションからカート情報を取得
			ArrayList<ItemDatabeans> cart = (ArrayList<ItemDatabeans>) EcHelper.cutSessionAttribute(session, "cart");

			BuyDatabeans bdb = (BuyDatabeans) EcHelper.cutSessionAttribute(session, "bdb");

			// 購入情報を登録
			int buyId = BuyDAO.insertBuy(bdb);
			// 購入詳細情報を購入情報IDに紐づけして登録
			for (ItemDatabeans cartInItem : cart) {
				BuyDetailDatabeans bddb = new BuyDetailDatabeans();
				bddb.setBuyId(buyId);
				bddb.setItemId(cartInItem.getId());
				BuyDetailDAO.insertBuyDetail(bddb);
			}


			/* ====購入完了ページ表示用==== */
			BuyDatabeans resultBDB = BuyDAO.getBuyDatabeansByBuyId(buyId);
			request.setAttribute("resultBDB", resultBDB);

			// 購入アイテム情報
			ArrayList<ItemDatabeans> buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
			request.setAttribute("buyIDBList", buyIDBList);

			// 購入完了ページ
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/BuyResult.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}