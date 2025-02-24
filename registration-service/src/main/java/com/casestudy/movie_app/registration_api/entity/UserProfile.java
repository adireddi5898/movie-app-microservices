package com.casestudy.movie_app.registration_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "email should not be blank")
	private String email;
	
	@NotBlank(message = "Password should not be blank")
	@Size(min = 8, max = 12, message = "Password should be 8-12 characters ")
	private String password;

}
