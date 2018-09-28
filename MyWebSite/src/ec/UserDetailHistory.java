package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDatabeans;
import beans.ItemDatabeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class UserDetailHistory
 */
@WebServlet("/UserDetailHistory")
public class UserDetailHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailHistory() {
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

			int buyId =Integer.parseInt(request.getParameter("buyId"));

			BuyDatabeans bdbResult = BuyDAO.getBuyDatabeansByBuyId(buyId);
			request.setAttribute("bdbResult", bdbResult);

			ArrayList<ItemDatabeans> itemList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
			session.setAttribute("itemList", itemList);

			request.getRequestDispatcher("/WEB-INF/jsp/UserDetailHistory.jsp").forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}



}
