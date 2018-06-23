package com.ts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.receipeDAO;
import com.ts.dto.receipeDTO;

@WebServlet("/receipeServlet")
public class receipeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	receipeDAO dao=new receipeDAO();
	
	List<receipeDTO> receipesList=dao.getAllreceipes();
	
	RequestDispatcher dispatcher=request.getRequestDispatcher("displayReceipes.jsp");
	request.setAttribute("receipesList", receipesList);
	dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
