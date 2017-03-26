package com.cdsxt.action;

import java.util.List;

import com.cdsxt.po.Dept;
import com.cdsxt.service.serviceImp.DeptServiceImpl;
import com.cdsxt.service.serviceImp.EmpServiceImpl;
import com.cdsxt.vo.EmpVo;

public class DeptAction {
	private List<Dept> depts;
	private List<EmpVo> empVos;
	private Integer deptno;
	public String findAll(){
		DeptServiceImpl deptServiceImpl = new DeptServiceImpl() ;
		this.depts = deptServiceImpl.findAll();
		return "depts";
	}
	public String findEmpVoByDeptno(){
		EmpServiceImpl empServiceImpl = new EmpServiceImpl() ;
		this.empVos = empServiceImpl.findEmpVoByDeptno(deptno);
		return "findEmpVoByDeptno";
	}
	public List<Dept> getDepts() {
		return depts;
	}
	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}
	public List<EmpVo> getEmpVos() {
		return empVos;
	}
	public void setEmpVos(List<EmpVo> empVos) {
		this.empVos = empVos;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
}
