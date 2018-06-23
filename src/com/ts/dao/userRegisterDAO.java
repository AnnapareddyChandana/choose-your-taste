package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ts.dbutility.DBConnection;
import com.ts.dto.hotelRegisterDTO;
import com.ts.dto.userRegisterDTO;

public class userRegisterDAO {
	public static int add(userRegisterDTO user){
		final String INSERT_QUERY="insert into userregister(userName,userPassword) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserPassword());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		
		public  userRegisterDTO getuserRegisterDTO(String userName,String userPassword){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			userRegisterDTO user=null;
		final String SELECT_QUERY = "select * from userregister where userName = ? and userPassword = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, userName);
			pst.setString(2, userPassword);
			rst = pst.executeQuery();
			if(rst.next()){
				 user=new userRegisterDTO();
				 user.setUserId(rst.getInt(1));
				 user.setUserName(rst.getString(2));
			System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
		/*public List<hotelRegisterDTO> getAllhotelRegisterDTO(){
			List<hotelRegisterDTO> list=new ArrayList<>();
			PreparedStatement pst = null;
			ResultSet rst = null;
		final String SELECT_QUERY = "select * from hotelregister ";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery();
			while(rst.next()){
				hotelRegisterDTO hotel=new hotelRegisterDTO();
				hotel.setHotelId(rst.getInt(1));
				hotel.setHotelName(rst.getString(2));
				hotel.setHotelPassword(rst.getString(3));
				list.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}*/
}

