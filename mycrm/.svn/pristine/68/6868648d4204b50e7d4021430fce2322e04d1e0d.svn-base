package com.cdsxt.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.web.service.StaffService;
import com.cdsxt.web.util.PageUtil;
import com.cdsxt.web.vo.StaffVo;

@Controller
@Scope("prototype")
public class StaffAction {
	@Autowired
	private StaffService staffService;
	
	private Integer curPage;
	
	private PageUtil page;
	
	private List<StaffVo> staffVos;
	
	public String findAll(){
		if(curPage==null){
			curPage=1;
		}
		page=new PageUtil(curPage, this.staffService.findCount());
		staffVos=this.staffService.findForPage(page.getStartRow(), page.getPageRow());
		return "findAll";
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public List<StaffVo> getStaffVos() {
		return staffVos;
	}

	public void setStaffVos(List<StaffVo> staffVos) {
		this.staffVos = staffVos;
	}

	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}
	
	
}
