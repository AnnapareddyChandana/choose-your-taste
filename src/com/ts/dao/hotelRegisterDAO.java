package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ts.dbutility.DBConnection;
import com.ts.dto.hotelRegisterDTO;

public class hotelRegisterDAO {
	public static int add(hotelRegisterDTO hotel){
		final String INSERT_QUERY="insert into hotelregister(hotelName,hotelPassword) values(?,?)";
		//System.out.println("fhehf"+INSERT_QUERY);
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, hotel.getHotelName());
			pst.setString(2, hotel.getHotelPassword());
			System.out.println(pst);
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		
		public  hotelRegisterDTO gethotelRegisterDTO(String hotelName,String hotelPassword){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			hotelRegisterDTO hotel=null;
		final String SELECT_QUERY = "select * from hotelregister where hotelName = ? and hotelPassword = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, hotelName);
			pst.setString(2, hotelPassword);
			rst = pst.executeQuery();
			if(rst.next()){
				 hotel=new hotelRegisterDTO();
				 hotel.setHotelId(rst.getInt(1));
				 hotel.setHotelName(rst.getString(2));
			System.out.println(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotel;
		}
		}

