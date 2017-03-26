package com.cdsxt.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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

	@Override
	public Emp findByEmpno(Integer empno) {
		Emp emp = null;
		Connection conn = DBUtils.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select e.* from emp_bak e where e.empno=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			rs = ps.executeQuery();
			while(rs.next()){
				emp = new Emp();
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setComm(rs.getDouble("comm"));
				emp.setSal(rs.getDouble("sal"));
				emp.setEmpno(rs.getInt("empno"));
				emp.setMgr(rs.getInt("mgr"));
				break;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs,ps,conn);
		}
		return emp;
	}

	@Override
	public void save(Emp emp) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into emp_bak(empno,ename,job,hiredate,mgr,sal,comm,deptno) values (?,?,?,?,?,?,?,?)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setObject(1, emp.getEmpno());
			ps.setObject(2, emp.getEname());
			ps.setObject(3, emp.getJob());
			ps.setObject(4, new Date(emp.getHiredate().getTime()));
			ps.setObject(5, emp.getMgr());
			ps.setObject(6, emp.getSal());
			ps.setObject(7, emp.getComm());
			ps.setObject(8, emp.getDeptno());
			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps,conn);
		}
	}
	
	@Override
	public void update(Emp emp) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "update emp_bak set ename=?,job=?,hiredate=?,mgr=?,sal=?,comm=?,deptno=? where empno=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setObject(8, emp.getEmpno());
			ps.setObject(1, emp.getEname());
			ps.setObject(2, emp.getJob());
			ps.setObject(3, new Date(emp.getHiredate().getTime()));
			ps.setObject(4, emp.getMgr());
			ps.setObject(5, emp.getSal());
			ps.setObject(6, emp.getComm());
			ps.setObject(7, emp.getDeptno());
			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps,conn);
		}
	}

}
