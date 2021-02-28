package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "role")
public class RoleEntity extends BaseEntity{
//	@Id //notnull va primary 
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // set autoincrement
//	private Long id;
	
	@Column(name = "code")
	private String code;
	
	public String getCode() {
		return code;
	}

	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> userEntity = new ArrayList<>();

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name")
	private String name;

}
