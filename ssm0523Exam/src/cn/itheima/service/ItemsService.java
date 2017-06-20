package cn.itheima.service;

import java.util.List;

import cn.itheima.pojo.Items;
import cn.itheima.pojo.QueryVo;

public interface ItemsService {

	
	public List<Items> showItemList() throws Exception;
	
	public Items findItemsById(Integer id) throws Exception;
	
	public void updateItems(Items items) throws Exception;
	
	public List<Items> searchByVo(QueryVo vo);
}
