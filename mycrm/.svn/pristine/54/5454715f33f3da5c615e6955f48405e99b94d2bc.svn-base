package com.cdsxt.web.po;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="crm_user",uniqueConstraints={@UniqueConstraint(columnNames={"user_name"})})
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	
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
//	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private List<Role> roles;
	
	@OneToOne(mappedBy="user")
	private Staff staff;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
	
	
}
