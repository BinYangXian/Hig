package com.cdsxt.web.dao;

import java.util.List;

import com.cdsxt.web.po.Staff;

public interface StaffDao {

	Staff findById(Integer id);

	List<Staff> findFroPage(int startRow, int pageRow);

	long findCount();

}
