package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.ts.dbutility.DBConnection;
import com.ts.dto.branchDTO;
import com.ts.dto.receipeDTO;

public class receipeDAO {
	
	
	/*public int add(receipeDTO receipe){
		final String INSERT_QUERY="insert into receipe(receipeId,receipeName,receipeType,receipePrice) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
			Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setLong(5,receipe.getReceipeId());
			pst.setString(1, receipe.getReceipeName());
			pst.setString(2, receipe.getReceipeType());
			pst.setLong(3, receipe.getReceipePrice());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}*/
	
	
	/*public receipeDTO getreceipe(String receipeName,String receipeType){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		receipeDTO receipe=null;
		final String SELECT_QUERY = "select * from receipe where receipeName = ? and receipeType = ?";
		try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, receipeName);
		pst.setString(2, receipeType);
		rst = pst.executeQuery();
		if(rst.next()){
			 receipe=new receipeDTO();
			 receipe.setReceipeId(rst.getInt(1));
			 receipe.setReceipeName(rst.getString(2));
			 receipe.setReceipeType(rst.getString(4));
			 receipe.setReceipePrice(rst.getInt(5));
		System.out.println(receipe);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return receipe;
	}*/



	public List<receipeDTO> getAllreceipes(){
		List<receipeDTO> list=new ArrayList<>();
		System.out.println("Inside servlet");
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from receipe ";
	try{
		Connection con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			receipeDTO receipe=new receipeDTO();
			receipe.setReceipeId(rst.getInt(1));
			receipe.setReceipeName(rst.getString(2));
			receipe.setReceipeType(rst.getString(3));
			receipe.setReceipePrice(rst.getInt(4));
			
			list.add(receipe);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}



public int editReceipe(receipeDTO receipe) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update receipe set receipeName= ?, receipeType = ? where receipeId = ?");
		pst.setInt(3, receipe.getReceipeId());
		pst.setString(1, receipe.getReceipeName());
		pst.setString(2, receipe.getReceipeType());
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+receipe);
	} catch (SQLException e) {				
		e.printStackTrace();
	}	
	finally{
		try {
			con.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
	return x;
}


	public receipeDTO getReceipe(int receipeId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		receipeDTO receipe=null;
	final String SELECT_QUERY = "select * from receipe where receipeId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, receipeId);
		rst = pst.executeQuery();
		if(rst.next()){
			 receipe=new receipeDTO();
			 receipe.setReceipeId(rst.getInt(1));
			 receipe.setReceipeName(rst.getString(2));
			 receipe.setReceipeType(rst.getString(3));
			 receipe.setReceipePrice(rst.getInt(4));
		System.out.println(receipe);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return receipe;
	}
	
	public int add(receipeDTO receipe){
		final String INSERT_QUERY="insert into selecteditems(receipeName,receipeType) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, receipe.getReceipeName());
			pst.setInt(2, receipe.getReceipePrice());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}