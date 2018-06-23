package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.receipeDAO;
import com.ts.dto.receipeDTO;

@WebServlet("/receipeEditServlet")
public class receipeEditServlet extends HttpServlet {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		int receipeId = Integer.parseInt(request.getParameter("receipe_id"));
		System.out.println("receipeID in Servletis:"+receipeId);
		receipeDTO receipe = new receipeDAO().getReceipe(receipeId);
			request.setAttribute("receipedata", receipe);			
RequestDispatcher rd = request.getRequestDispatcher("EditReceipe.jsp");
			rd.forward(request, response);
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
}