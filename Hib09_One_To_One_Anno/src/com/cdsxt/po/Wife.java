package com.cdsxt.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="test_wife")
public class Wife {
	
	/**
	 * <id>
	 * 	<generator class="foreign">
	 * 		<param name="property">husband</param>
	 *  </generator>
	 * </id>
	 * 
	 * 
	 */
	@Id
	@GenericGenerator(
		name="wifeGG",
		strategy="foreign",
		parameters={
			@Parameter(name="property",value="husband")
		}
	)
	@GeneratedValue(generator="wifeGG")
	private Integer id;
	private String wname;
	
	@OneToOne(mappedBy="wife")
	private Husband husband;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
}
