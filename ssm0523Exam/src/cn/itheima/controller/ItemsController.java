package cn.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itheima.pojo.Items;
import cn.itheima.pojo.QueryVo;
import cn.itheima.service.ItemsService;
@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemService;
	@RequestMapping("/list")
	public String showItemList(Model m) throws Exception{
		List<Items> list = itemService.showItemList();
		m.addAttribute("itemList", list);
		return "itemList";
	}
	@RequestMapping("/search")
	public String searchByNameAndPri(Model m,QueryVo vo){
		List<Items> list = itemService.searchByVo(vo);
		m.addAttribute("itemList", list);
		return "itemList";
	}
	@RequestMapping("/updateitem")
	public String update(Items item) throws Exception{
		itemService.updateItems(item);
		return "success";
	}
	@RequestMapping("/itemEdit")
	public String searchByNameAndPri(Model m,Integer id) throws Exception{
		Items item = itemService.findItemsById(id);
		m.addAttribute("item", item);
		return "editItem";
	}
}
