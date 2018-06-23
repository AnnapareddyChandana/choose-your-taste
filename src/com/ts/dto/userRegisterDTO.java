package com.ts.dto;
public class userRegisterDTO {
	private int userId;
	private String userName;
	private String userPassword;
	public userRegisterDTO(int userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public userRegisterDTO(){}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "userRegisterDTO [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
}
