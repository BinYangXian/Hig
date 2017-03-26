package com.cdsxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdsxt.po.Company;
import com.cdsxt.service.CompanyService;
import com.cdsxt.service.impl.CompanyServiceImpl;

public class CompanyAction {

	private CompanyService companyService = new CompanyServiceImpl();
	
	private List<Company> companys;
	private List<Map<String,Object>> vos;
	
	//当前的父公司
	private Company company;
	
	//接受父id的值
	private Integer parent;

	
	public String findAll(){
		if(parent!=null){
			this.company = this.companyService.findById(parent);
		}
		this.companys = this.companyService.findByParentId(parent);
		return "findAll";
	}

	public String findAllToJson(){
		this.companys = this.companyService.findAll();
		if(this.companys!=null){
			this.vos = new ArrayList<>();
			for(Company c:companys){
				Map<String,Object> vo = new HashMap<>();
				vo.put("id", c.getId());
				Company parent = c.getParent();
				vo.put("parent", parent==null?0:parent.getId());
				vo.put("name", c.getName());
				vos.add(vo);
			}
		}
		return "findAllToJson";
	}
	public List<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}
	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Map<String, Object>> getVos() {
		return vos;
	}

	public void setVos(List<Map<String, Object>> vos) {
		this.vos = vos;
	}
}
