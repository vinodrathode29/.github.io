package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet({ "/ShowCartServlet", "/ShowCart" })
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		CartDao cartDao = new CartDaoSqlImpl();
		List<MenuItem> cartItems = cartDao.getAllCartItems(1);
		
		double total=0;
		for(MenuItem menuItem:cartItems)
		{
			total +=menuItem.getPrice();
			request.setAttribute("total", total);
		}
		  request.setAttribute("cartItems", cartItems);
          
          
          
          RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
			
		}
		catch (Exception ex) {
				request.getRequestDispatcher("cart-empty.jsp").forward(request, response);

			} 

		} 
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
