package com.ts.web;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.branchDAO;
import com.ts.dao.hotelLoginDAO;
import com.ts.dao.hotelRegisterDAO;

import com.ts.dto.branchDTO;
import com.ts.dto.hotelRegisterDTO;
@WebServlet("/hotelLogin")
public class hotelLogin extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String hotelName=request.getParameter("Hname");
		String hotelPassword=request.getParameter("pwd");
		//String hotelID=request.getParameter("id");
		hotelLoginDAO HotelDao = new hotelLoginDAO();
		hotelRegisterDTO Hotel=HotelDao.getHotel(hotelName, hotelPassword);
		System.out.println("Inside servlet:"+Hotel);
		out.println("<html>");
		if(Hotel !=null){
		branchDAO b=new branchDAO();
		//hotelRegisterDTO h=b.gethotelId1(hotelName);
		hotelRegisterDAO h1 = new hotelRegisterDAO();
		hotelRegisterDTO h=h1.gethotelRegisterDTO(hotelName, hotelPassword);
		System.out.println(h.hotelId);
		System.out.println("final output");
		
		
		hotelRegisterDTO hotel=new hotelRegisterDTO();
		hotel.setHotelName(hotelName);
		hotel.setHotelPassword(hotelPassword);
		//System.out.println(hotel);
		branchDAO hotelDao = new branchDAO();
		java.util.List<branchDTO> branchList=hotelDao.getAllBranches(h.hotelId);
		if(hotel!=null){
			request.setAttribute("branchesList",branchList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("branchDisplay.jsp");
			dispatcher.include(request, response);
		}
		}else{
			out.println("<h2 text=white>You dont have an account.Please Register...</h2>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("hotelRegister.html");
			dispatcher.include(request, response);	
			
		}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request,response);
	}
}
