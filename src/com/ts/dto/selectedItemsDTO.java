package com.ts.dto;

public class selectedItemsDTO {
	private String receipeName;
	@Override
	public String toString() {
		return "selectedItemsDTO [receipeName=" + receipeName + ", receipePrice=" + receipePrice + ", receipeQuantity="
				+ receipeQuantity + ", receipeTotal=" + receipeTotal + "]";
	}

	private int receipePrice;
	private int receipeQuantity;
	private int receipeTotal;

	public int getReceipeTotal() {
		return receipeTotal;
	}
	public void setReceipeTotal(int receipeTotal) {
		this.receipeTotal = receipeTotal;
	}
	public selectedItemsDTO(int receipeTotal) {
		super();
		this.receipeTotal = receipeTotal;
	}
	public selectedItemsDTO(){}
	public String getReceipeName() {
		return receipeName;
	}
	public void setReceipeName(String receipeName) {
		this.receipeName = receipeName;
	}
	public int getReceipePrice() {
		return receipePrice;
	}
	public void setReceipePrice(int receipePrice) {
		this.receipePrice = receipePrice;
	}
	public int getReceipeQuantity() {
		return receipeQuantity;
	}
	public void setReceipeQuantity(int receipeQuantity) {
		this.receipeQuantity = receipeQuantity;
	}
	
		public selectedItemsDTO(String receipeName, int receipePrice, int receipeQuantity) {
		super();
		this.receipeName = receipeName;
		this.receipePrice = receipePrice;
		this.receipeQuantity = receipeQuantity;
	}
	

}
