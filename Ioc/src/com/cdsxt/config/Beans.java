package com.cdsxt.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="beans")
public class Beans {

	List<Bean> beans = new ArrayList<>();

	@XmlElement(name="bean")
	public List<Bean> getBeans() {
		return beans;
	}

	public void setBeans(List<Bean> beans) {
		this.beans = beans;
	}
	
	
}
