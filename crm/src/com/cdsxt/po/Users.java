package com.cdsxt.po;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="crm_user")
public class Users {

	@Id
	@SequenceGenerator(name="seqUser",sequenceName="seq_crm_user")
	@GeneratedValue(generator="seqUser")
	@Column(name="user_id")
	private Integer id;
	@Column(name="uname",nullable=false,unique=true)
	private String username;
	@Column(name="pwd")
	private String password;
	private String email;
	
	@ManyToMany
	@JoinTable(
			name="crm_user_role",
			joinColumns={
					@JoinColumn(name="user_id")
			},
			inverseJoinColumns={
					@JoinColumn(name="role_id")
			}
	)
	private Set<Role> roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
