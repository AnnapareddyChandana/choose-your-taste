package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;

import com.ts.dto.userRegisterDTO;


public class userLoginDAO {
public userRegisterDTO getuser(String userName,String userPassword){
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	userRegisterDTO user=null;
final String SELECT_QUERY = "select * from userregister where userName = ? and userPassword = ?";
try{
	con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(1, userName);
	pst.setString(2, userPassword);
	rst = pst.executeQuery();
	if(rst.next()){
		 user=new userRegisterDTO();
		 user.setUserId(rst.getInt(1));
		 user.setUserName(rst.getString(2));
		 user.setUserPassword(rst.getString(3));
	System.out.println(user);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return user;
}

public static boolean add(boolean b) {
	
	return false;
}
}