package com.cdsxt.action;

import java.util.List;

import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;
import com.cdsxt.service.impl.EmpServiceImpl;
import com.cdsxt.vo.EmpVo;

public class EmpAction {

	private Integer deptno;
	private EmpService empService = new EmpServiceImpl();
	
	private List<Emp> emps;
	private List<EmpVo> vos;
	
	public void findAll(){
		
	}
	
	public String findByDeptno(){
		if(deptno!=null){
			this.emps = this.empService.findByDeptno(deptno);
		}
		return "findByDeptno";
	}
	public String findEmpVoByDeptno(){
		if(deptno!=null){
			this.vos = this.empService.findEmpVoByDeptno(deptno);
		}
		return "findEmpVoByDeptno";
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public List<EmpVo> getVos() {
		return vos;
	}

	
}
