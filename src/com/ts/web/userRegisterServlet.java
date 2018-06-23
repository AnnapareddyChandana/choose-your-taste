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
import com.ts.dao.userRegisterDAO;
import com.ts.dto.hotelRegisterDTO;
import com.ts.dto.userRegisterDTO;

@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("Uname");
		String userPassword=request.getParameter("pwd");
		userRegisterDTO user=new userRegisterDTO();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		System.out.println(user);
		
//		HttpSession session=request.getSession();
	//	session.setAttribute("loggedUser", hotelName);
		//response.setContentType("text/html");
		
		userRegisterDAO userDao = new userRegisterDAO();
		//hotelRegisterDTO hotel=hotelDao.gethotelRegisterDTO(hotelName, hotelPassword);
		//System.out.println("Inside servlet:"+hotel);
		//out.println("</html>");
		if(userRegisterDAO.add(user)!=0){
			response.getWriter().println("<h1>Registration Success</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("userLogin.html");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}