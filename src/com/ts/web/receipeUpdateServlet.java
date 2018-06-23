package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.receipeDAO;
import com.ts.dto.receipeDTO;

@WebServlet("/receipeUpdateServlet")
public class receipeUpdateServlet extends HttpServlet {
	private Connection con = null;
	private PreparedStatement pst = null;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();			
		int receipeId = Integer.parseInt(request.getParameter("receipeId"));
		String receipeName = request.getParameter("receipeName");
		String receipeType = request.getParameter("receipeType");
		int receipePrice = Integer.parseInt(request.getParameter("receipePrice"));
		
		receipeDTO receipe=new receipeDTO();
		receipe.setReceipeId(receipeId);
		receipe.setReceipeName(receipeName);
		receipe.setReceipeType(receipeType);
		receipe.setReceipePrice(receipePrice);
		System.out.println("Inside Update Servlet:"+receipe);
		int x = new receipeDAO().editReceipe(receipe);
		if(x > 0) {											
			RequestDispatcher rd = request.getRequestDispatcher("receipeServlet");
			rd.include(request, response);
			out.println("<center><h1>Update Successful...</h1><center>");			
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
}