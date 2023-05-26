package com.example.WorkshopMongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.WorkshopMongo.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	private Date birthDate;
	private String CPF;
	private String country;
	private String phone;
	
	public UserDTO() {
		
	}
	public UserDTO(User obj) { 	//Padrão DTO
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		birthDate = obj.getBirthDate();
		CPF = obj.getCPF();
		country = obj.getCountry();
		phone = obj.getPhone();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
