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
import beans.DeliveryMethodDatabeans;
import beans.ItemDatabeans;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class BuyItemResult
 */
@WebServlet("/BuyItemResult")
public class BuyItemResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyItemResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			//選択された配送方法IDを取得
			int inputDeliveryMethodId = Integer.parseInt(request.getParameter("delivery_method_id"));
			//選択されたIDをもとに配送方法Beansを取得
			DeliveryMethodDatabeans userSelectDMB = DeliveryMethodDAO.getDeliveryMethodDatabeansByID(inputDeliveryMethodId);
			//買い物かご
			ArrayList<ItemDatabeans> cartIDBList = (ArrayList<ItemDatabeans>) session.getAttribute("cart");
			//合計金額
			int totalPrice = EcHelper.getTotalItemPrice(cartIDBList) + userSelectDMB.getPrice();

			BuyDatabeans bdb = new BuyDatabeans();
			bdb.setUserId((int) session.getAttribute("userId"));
			bdb.setTotalPrice(totalPrice);
			bdb.setDelivertMethodId(userSelectDMB.getId());
			bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());
			bdb.setDeliveryMethodName(userSelectDMB.getName());



			//購入確定で利用
			session.setAttribute("bdb", bdb);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/BuyItemResult.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
