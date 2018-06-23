package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ts.dbutility.DBConnection;
import com.ts.dto.hotelRegisterDTO;
import com.ts.dto.selectedItemsDTO;

public class selectedItemsDAO {
	public static int add(selectedItemsDTO item){
		final String INSERT_QUERY="insert into selecteditems(receipeName,receipePrice,receipeQuantity) values(?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, item.getReceipeName());
			pst.setInt(2, item.getReceipePrice());
			pst.setInt(3, item.getReceipeQuantity());
			System.out.println(pst);
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}}
		
		/*public  hotelRegisterDTO gethotelRegisterDTO(String hotelName,String hotelPassword){
			
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
		}*/

