package com.exam.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	private Long role_id;
	private String role_name;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="role")
	private Set<UserRole> userRole = new HashSet<>();
	
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role_name;
	}
	public void setRole(String role_name) {
		this.role_name = role_name;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Long role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	

}
