package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ts.dao.hotelRegisterDAO;
import com.ts.dao.selectedItemsDAO;
import com.ts.dto.hotelRegisterDTO;
import com.ts.dto.selectedItemsDTO;

@WebServlet("/selectedItemsServlet")
public class selectedItemsServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String itemName=request.getParameter("name");
		int itemPrice=Integer.parseInt(request.getParameter("price"));
		int itemQuantity=Integer.parseInt(request.getParameter("quantity"));

		selectedItemsDTO item=new selectedItemsDTO();
		item.setReceipeName(itemName);
		item.setReceipePrice(itemPrice);
		item.setReceipeQuantity(itemQuantity);
		
		selectedItemsDAO hotelDao = new selectedItemsDAO();
		if(selectedItemsDAO.add(item)!=0){
			response.getWriter().println("<h1>Added Successfully more.....</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("selectedItems.jsp");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}