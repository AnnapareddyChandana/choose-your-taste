package com.ts.dto;

public class hotelRegisterDTO {
	public int hotelId;
	public String hotelName;
	private String hotelPassword;
	
	public hotelRegisterDTO(){}
	
	public hotelRegisterDTO(int hotelId, String hotelName, String hotelPassword) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelPassword = hotelPassword;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelPassword() {
		return hotelPassword;
	}
	public void setHotelPassword(String hotelPassword) {
		this.hotelPassword = hotelPassword;
	}
	@Override
	public String toString() {
		return "hotelRegisterDTO [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelPassword=" + hotelPassword
				+ "]";
	}
}
