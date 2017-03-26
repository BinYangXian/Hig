package com.cdsxt.po;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="company")
public class Company {

	@Id
	@SequenceGenerator(name="seqCompany",sequenceName="seq_company")
	@GeneratedValue(generator="seqCompany")
	private Integer id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="parent")
	private Company parent;
	
	@OneToMany(mappedBy="parent")
	private Set<Company> childs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Company getParent() {
		return parent;
	}
	public void setParent(Company parent) {
		this.parent = parent;
	}
	public Set<Company> getChilds() {
		return childs;
	}
	public void setChilds(Set<Company> childs) {
		this.childs = childs;
	}
	
	
}
