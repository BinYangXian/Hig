package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Emp;
import com.cdsxt.vo.EmpVo;

public interface EmpService {

	List<Emp> findByDeptno(Integer deptno);
	List<EmpVo> findEmpVoByDeptno(Integer deptno);
}
