package com.ezen.dto;

public class MemberDto {
	   private String userId;
	   private String userName;
	   private String userPassword;
	   
	   public MemberDto() {}

	   public MemberDto(String userId, String userName, String userPassword) {
	      super();
	      this.userId = userId;
	      this.userName = userName;
	      this.userPassword = userPassword;
	   }

	   public String getUserId() {
	      return userId;
	   }

	   public void setUserId(String userId) {
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
	      return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	   }

	   
	}
