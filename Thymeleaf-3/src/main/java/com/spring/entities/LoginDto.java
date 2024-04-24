package com.spring.entities;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
	
	@NotBlank(message = "usermail cannot be empty")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Mail-ID")
	private String userMail;


	@NotBlank(message = "username cannot be empty")
	@Size(min = 3,max = 12,message = "user name should be 3-12 character long")
	private String userName;
	
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Override
	public String toString() {
		return "LoginDto [userMail=" + userMail + ", userName=" + userName + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginDto(
			@NotBlank(message = "usermail cannot be empty") @Pattern(regexp = "/([a-zA-Z0-9]+)([\\.{1}])?([a-zA-Z0-9]+)\\@gmail([\\.])com/g", message = "Invalid Mail-ID") String userMail,
			@NotBlank(message = "username cannot be empty") @Size(min = 3, max = 12, message = "user name should be 3-12 character long") String userName) {
		super();
		this.userMail = userMail;
		this.userName = userName;
	}

	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
