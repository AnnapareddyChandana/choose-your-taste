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
import com.ts.dto.hotelRegisterDTO;

@WebServlet("/hotelRegister")
public class hotelRegister extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String hotelName=request.getParameter("Hname");
		String hotelPassword=request.getParameter("pwd");
		hotelRegisterDTO hotel=new hotelRegisterDTO();
		hotel.setHotelName(hotelName);
		hotel.setHotelPassword(hotelPassword);
		
//		HttpSession session=request.getSession();
	//	session.setAttribute("loggedUser", hotelName);
		
		
		//response.setContentType("text/html");
		
		hotelRegisterDAO hotelDao = new hotelRegisterDAO();
		//hotelRegisterDTO hotel=hotelDao.gethotelRegisterDTO(hotelName, hotelPassword);
		//System.out.println("Inside servlet:"+hotel);
		//out.println("</html>");
		if(hotelRegisterDAO.add(hotel)!=0){
			response.getWriter().println("<h1>Registration Success</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("hotelLogin.html");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}