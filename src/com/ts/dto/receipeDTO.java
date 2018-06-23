package com.ts.dto;

public class receipeDTO {
	
	private int receipeId;
	private String receipeName;
	private String receipeType;
	private int receipePrice;

	public receipeDTO(){}
	
	public receipeDTO(int receipeId, String receipeName, String receipeType, int receipePrice) {
		super();
		this.receipeId = receipeId;
		this.receipeName = receipeName;
		this.receipeType = receipeType;
		this.receipePrice = receipePrice;
	}
	
	public int getReceipeId() {
		return receipeId;
	}
	public void setReceipeId(int receipeId) {
		this.receipeId = receipeId;
	}
	public String getReceipeName() {
		return receipeName;
	}
	public void setReceipeName(String receipeName) {
		this.receipeName = receipeName;
	}
	public String getReceipeType() {
		return receipeType;
	}
	public void setReceipeType(String receipeType) {
		this.receipeType = receipeType;
	}
	public int getReceipePrice() {
		return receipePrice;
	}
	public void setReceipePrice(int receipePrice) {
		this.receipePrice = receipePrice;
	}
	
	
	
	@Override
	public String toString() {
		return "receipeDTO [receipeId=" + receipeId + ", receipeName=" + receipeName + ", receipeType=" + receipeType
				+ ", receipePrice=" + receipePrice + "]";
	}
}
