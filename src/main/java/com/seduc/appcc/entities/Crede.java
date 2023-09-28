package com.seduc.appcc.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_credes")
public class Crede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "ds_nome")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_crede_id")
	private List<School> escolas;

	public Crede(String name) {
		this.name = name;
	}
	public Crede() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<School> getEscolas() {
		return escolas;
	}
	public void setEscolas(List<School> escolas) {
		this.escolas = escolas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(escolas, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crede other = (Crede) obj;
		return Objects.equals(escolas, other.escolas) && id == other.id && Objects.equals(name, other.name);
	}
	
	
	
	
	
	
		
	
}
