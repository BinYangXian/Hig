package com.cdsxt.sell.util;

public class PageUtil2 {
	//每页显示条数
	private int pageRow;
	//总条数
	private int rowCount;
	//总导航数
	private int navCount;
	//起始行
	private int startRow;
	//当前页
	private int curPage;
	//上一页
	private int prevPage;
	//下一页
	private int nextPage;
	//首页
	private int firstPage=1;
	//尾页
	private int lastPage;
	//起始导航
	private int startNav;
	//结束导航
	private int endNav;
	
	//传入当前页 和总条数
	public PageUtil2(int curPage,int rowCount){
		this.curPage=curPage;
		this.rowCount=rowCount;
		//总条数%每页显示条数==0?总条数/每页显示条数:总条数/每页显示条数+1
		this.navCount=this.rowCount%10==0?this.rowCount/10:this.rowCount/10+1;
		//起始行  (当前页-1)*每页多少条数据   
		this.startRow=(this.curPage-1)*10;
		this.lastPage=this.navCount;
		//上一页 当前页-1 >0?当前页-1:首页
		this.prevPage=this.curPage-1>0?this.curPage-1:this.firstPage;
		//当前页+1<=尾页?当前页+1:尾页
		this.nextPage=this.curPage+1<=this.lastPage?this.curPage+1:this.lastPage;
	
		if(this.navCount<10){
			this.startNav=this.firstPage;
			this.endNav=this.lastPage;
		}else{
			if(this.curPage<=6){
				//靠近首页的情况
				this.startNav=this.firstPage;
				this.endNav=10;
			}else if(this.curPage>=this.lastPage-4){
				//靠近尾页的情况
				this.startNav=this.lastPage-9;
				this.endNav=this.lastPage;
			}else{
				//正常情况
				this.startNav=this.curPage-5;
				this.endNav=this.curPage+4;
			}
		}
	}
	
	public static void main(String[] args) {
		PageUtil2 pageUtil=new PageUtil2(7, 67);
		System.out.println("总条数:"+pageUtil.getRowCount());
		System.out.println("总导航数:"+pageUtil.getNavCount());
		System.out.println("起始行:"+pageUtil.getStartRow());
		System.out.println("当前页:"+pageUtil.getCurPage());
		System.out.println("前一页:"+pageUtil.getPrevPage());
		System.out.println("后一页:"+pageUtil.getNextPage());
		System.out.println("首页:"+pageUtil.getFirstPage());
		System.out.println("尾页:"+pageUtil.getLastPage());
		System.out.println("起始导航："+pageUtil.getStartNav());
		System.out.println("结束导航:"+pageUtil.getEndNav());
		System.out.println("每页显示条数："+pageUtil.getPageRow());
	}
	
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getNavCount() {
		return navCount;
	}
	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStartNav() {
		return startNav;
	}
	public void setStartNav(int startNav) {
		this.startNav = startNav;
	}
	public int getEndNav() {
		return endNav;
	}
	public void setEndNav(int endNav) {
		this.endNav = endNav;
	}
	
}
