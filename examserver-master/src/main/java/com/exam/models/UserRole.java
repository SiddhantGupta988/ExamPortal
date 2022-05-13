package com.exam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class UserRole {
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
private int user_role_id;

@ManyToOne(fetch =FetchType.EAGER)
private User user;

@ManyToOne()
private Role role;

public UserRole() {
	super();
	// TODO Auto-generated constructor stub
}

public int getUser_role_id() {
	return user_role_id;
}

public void setUser_role_id(int user_role_id) {
	this.user_role_id = user_role_id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public UserRole(int user_role_id, User user, Role role) {
	super();
	this.user_role_id = user_role_id;
	this.user = user;
	this.role = role;
}

}
