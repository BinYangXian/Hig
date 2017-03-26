package com.cdsxt.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdsxt.dao.BaseDao;
import com.cdsxt.dao.EmpDao;
import com.cdsxt.po.Emp;
import com.cdsxt.utils.DBUtils;

@Repository
public class EmpDaoImpl implements EmpDao{

	@Override
	public List<Emp> findAll() {
		List<Emp> emps = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from emp_bak";
		try{
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Emp emp = new Emp();
				emps.add(emp);
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setComm(rs.getDouble("comm"));
				emp.setSal(rs.getDouble("sal"));
				emp.setEmpno(rs.getInt("empno"));
				emp.setMgr(rs.getInt("mgr"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs,ps,conn);
		}
		return emps;
	}
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Date hiredate;
	private Double comm;
	private Integer mgr;
	private Integer deptno;
	@Override
	public void addEmp(Emp e) {
		BaseDao.change("insert into emp_bak values(?,?,?,?,?,?,?,?)", new Object[]{e.getEmpno(),e.getEname()
				,e.getJob()
				,e.getMgr()
				,e.getHiredate()
				,e.getSal()
				,e.getComm()
				,e.getDeptno()
				});
	}

	@Override
	public void changeEmp(Emp e) {
		BaseDao.change("update emp_bak set deptno=?,ename=?,job=?,hiredate=?,comm=?,sal=?,empno=?,mgr=?"
				, new Object[]{e.getEmpno(),e.getEname()
						,e.getJob()
						,e.getMgr()
						,e.getHiredate()
						,e.getSal()
						,e.getComm()
						,e.getDeptno()});
	}

	@Override
	public Emp findEmpById(Integer empno) {
		Emp e=BaseDao.queryById("select * from emp_bak where empno=?",empno,new Emp());
		return e;
	}
	@Override
	public void delete(Integer empno) {
		BaseDao.change("delete from emp_bak where empno=?", new Object[]{empno});
	}
}
