package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Emp;
import com.cdsxt.vo.EmpVo;

public interface EmpDao {

	List<Emp> findByDeptno(Integer deptno);

	List<EmpVo> findEmpVoByDeptno(Integer deptno);
	
}
