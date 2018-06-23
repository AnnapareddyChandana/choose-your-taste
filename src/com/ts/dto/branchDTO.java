package com.ts.dto;

public class branchDTO {
	private int branchId;
	private String branchAddress;
	private int hotelID;
	public branchDTO(){};
	public branchDTO(int branchId, String branchAddress, int hotelID) {
		super();
		this.branchId = branchId;
		this.branchAddress = branchAddress;
		this.hotelID = hotelID;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	@Override
	public String toString() {
		return "branchDTO [branchId=" + branchId + ", branchAddress=" + branchAddress + ", hotelID=" + hotelID + "]";
	}
}
