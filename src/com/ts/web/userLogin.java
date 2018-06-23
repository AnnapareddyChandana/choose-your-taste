package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.userLoginDAO;
import com.ts.dto.userRegisterDTO;

@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("Uname");
		String userPassword=request.getParameter("pwd");
			
		response.setContentType("text/html");
		 
		userLoginDAO userDao = new userLoginDAO();
		userRegisterDTO user=userDao.getuser(userName,userPassword);
		System.out.println("Inside servlet:"+user);
		out.println("<html>");
		if(user !=null){
RequestDispatcher d=request.getRequestDispatcher("DisplayRestaurants.jsp");	
		d.forward(request, response);			
		}
		else{
	out.println("<h2  text=white> You dont have an account.Please Register.</h2>");
RequestDispatcher dispatcher=request.getRequestDispatcher("userRegistrationForm.html");
		dispatcher.include(request, response);		
		}
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}