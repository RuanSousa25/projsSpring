package com.seduc.appcc.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_superintendente_id")
	private List<Crede> crede;
	
	
	@Column(name = "ds_username")
	private String name;
	
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_senha")
	private String password;
	
	public User(List<Crede> crede, String name, String email, String password) {
		super();
		this.crede = crede;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Crede> getCrede() {
		return crede;
	}
	public void setCrede(List<Crede> crede) {
		this.crede = crede;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
