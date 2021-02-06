package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{
	// ORM technique
//		@Id //notnull va primary 
//		@GeneratedValue(strategy = GenerationType.IDENTITY) // set autoincrement
//		private Long id;
		
		@Column(name = "username")
		private String userName;
		
		@Column(name = "password")
		private String passWord;

		@Column(name = "fullname")
		private String fullName;
		
		@Column(name = "status")
		private Integer  status;
		
		//EAGER load bang phu len cung luc
		//lazy load sau (can congif)
		@ManyToMany
		@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"),
				inverseJoinColumns = @JoinColumn(name = "roleid"))
		private List<RoleEntity> roles = new ArrayList<>();
		
		public List<RoleEntity> getRoles() {
			return roles;
		}

		public void setRoles(List<RoleEntity> roles) {
			this.roles = roles;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}
}