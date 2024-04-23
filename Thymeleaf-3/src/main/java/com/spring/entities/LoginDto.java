package com.spring.entities;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
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
	private String userMail;

	@NotBlank(message = "username cannot be empty")
	@Size(min = 3,max = 12,message = "user name should be 3-12 character long")
	private String userName;
}
