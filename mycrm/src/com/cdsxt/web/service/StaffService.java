package com.cdsxt.web.service;

import java.util.List;

import com.cdsxt.web.vo.StaffVo;

public interface StaffService {

	List<StaffVo> findForPage(int startRow, int pageRow);

	int findCount();

}
