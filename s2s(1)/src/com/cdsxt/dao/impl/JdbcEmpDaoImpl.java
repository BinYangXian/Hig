package com.cdsxt.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.JdbcEmpDao;
import com.cdsxt.po.Emp;

@Repository
public class JdbcEmpDaoImpl implements JdbcEmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Emp> findAll() {
		return this.jdbcTemplate.query("select * from emp_bak", new RowMapper<Emp>(){

			@Override
			public Emp mapRow(ResultSet rs, int num) throws SQLException {
				Emp emp  = new Emp();
				emp.setDeptno(rs.getInt("deptno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setComm(rs.getDouble("comm"));
				emp.setSal(rs.getDouble("sal"));
				emp.setEmpno(rs.getInt("empno"));
				emp.setMgr(rs.getInt("mgr"));
				return emp;
			}
		});
	}

	@Override
	public Emp findByEmpno(Integer empno) {
		return this.jdbcTemplate.query("select * from emp_bak where empno=?", new Object[]{empno}, new ResultSetExtractor<Emp>(){

			@Override
			public Emp extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					Emp emp  = new Emp();
					emp.setDeptno(rs.getInt("deptno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setComm(rs.getDouble("comm"));
					emp.setSal(rs.getDouble("sal"));
					emp.setEmpno(rs.getInt("empno"));
					emp.setMgr(rs.getInt("mgr"));
					return emp;
				}
				return null;
			}
			
		});
	}

	@Override
	public void save(final Emp emp) {
		this.jdbcTemplate.update("insert into emp_bak(empno,ename,job,hiredate,mgr,sal,comm,deptno) values (?,?,?,?,?,?,?,?)", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setObject(1, emp.getEmpno());
				ps.setObject(2, emp.getEname());
				ps.setObject(3, emp.getJob());
				ps.setObject(4, new Date(emp.getHiredate().getTime()));
				ps.setObject(5, emp.getMgr());
				ps.setObject(6, emp.getSal());
				ps.setObject(7, emp.getComm());
				ps.setObject(8, emp.getDeptno());
			}
		});
	}

	@Override
	public void update(final Emp emp) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update emp_bak set ename=?,job=?,hiredate=?,mgr=?,sal=?,comm=?,deptno=? where empno=?", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setObject(8, emp.getEmpno());
				ps.setObject(1, emp.getEname());
				ps.setObject(2, emp.getJob());
				ps.setObject(3, new Date(emp.getHiredate().getTime()));
				ps.setObject(4, emp.getMgr());
				ps.setObject(5, emp.getSal());
				ps.setObject(6, emp.getComm());
				ps.setObject(7, emp.getDeptno());
			}
		});
	}

}
