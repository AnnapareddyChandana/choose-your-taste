package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import com.ts.dbutility.DBConnection;
import com.ts.dto.branchDTO;
import com.ts.dto.hotelRegisterDTO;

public class branchDAO {
	
	public static int add(branchDTO branch){
		final String INSERT_QUERY="insert into branch(branchId,branchPassword,hotelID) values(?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, branch.getHotelID());
			pst.setInt(2, branch.getBranchId());
			pst.setString(3, branch.getBranchAddress());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
			
		public List<branchDTO> getAllBranches(int hotelId){
			List<branchDTO> branchList=new ArrayList<>();
			PreparedStatement pst = null;
			ResultSet rst = null;
		final String SELECT_QUERY = "select * from branch where hotelID="+hotelId;
		System.out.println(hotelId);
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(SELECT_QUERY);
			rst = pst.executeQuery(SELECT_QUERY);
			while(rst.next()){
				branchDTO branch=new branchDTO();
				branch.setBranchId(rst.getInt(1));
				branch.setHotelID(rst.getInt(2));
				branch.setBranchAddress(rst.getString(3));
				branchList.add(branch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(branchList);
		return branchList;
		
		}
}
