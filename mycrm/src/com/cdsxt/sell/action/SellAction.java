package com.cdsxt.sell.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.sell.po.DevCustom;
import com.cdsxt.sell.service.DevcustomService;
import com.cdsxt.sell.util.PageUtil2;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class SellAction {
	
	@Autowired
	private DevcustomService devcustomService;
	
	private Integer curPage;
	
	private Integer rowPage;
	
	private List<DevCustom> devCustoms;
	public String findAll(){
		int rowCount=devcustomService.findCount();
		if(curPage==null){
			curPage=1;
		}
		PageUtil2 page=new PageUtil2(curPage, rowCount);
		if(rowPage==null){
			Map<String, Object> session=ActionContext.getContext().getSession();
			rowPage=(Integer) session.get("rowPage");
			if(rowPage==null){
				rowPage=10;
			}
		}
		devCustoms=devcustomService.findFroPage(page.getStartRow(), rowPage);
		return "findAll";
	}
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getRowPage() {
		return rowPage;
	}
	public void setRowPage(Integer rowPage) {
		this.rowPage = rowPage;
	}
	public List<DevCustom> getDevCustoms() {
		return devCustoms;
	}
	public void setDevCustoms(List<DevCustom> devCustoms) {
		this.devCustoms = devCustoms;
	}

	public DevcustomService getDevcustomService() {
		return devcustomService;
	}

	public void setDevcustomService(DevcustomService devcustomService) {
		this.devcustomService = devcustomService;
	}
	
	
}
