package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.hotelRegisterDTO;


public class hotelLoginDAO {
public hotelRegisterDTO getHotel(String userName,String password){
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	hotelRegisterDTO hotel=null;
final String SELECT_QUERY = "select * from hotelregister where hotelName = ? and hotelPassword = ?";
try{
	con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(1, userName);
	pst.setString(2, password);
	rst = pst.executeQuery();
	if(rst.next()){
		 hotel=new hotelRegisterDTO();
		 hotel.setHotelId(rst.getInt(1));
		 hotel.setHotelName(rst.getString(2));
		 hotel.setHotelPassword(rst.getString(5));
	System.out.println(hotel);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return hotel;
}

public static boolean add(boolean b) {
	
	return false;
}
}