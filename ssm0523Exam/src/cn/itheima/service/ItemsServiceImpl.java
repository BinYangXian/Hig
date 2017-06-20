package cn.itheima.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.dao.ItemsMapper;
import cn.itheima.pojo.Items;
import cn.itheima.pojo.ItemsExample;
import cn.itheima.pojo.QueryVo;


@Service
public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsMapper itemsMapper;
	@Autowired
	private SqlSessionFactory factory;
	public List<Items> showItemList(){
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}
	public List<Items> searchByVo(QueryVo vo) {
		System.out.println("*******************Name()="+vo.getItems().getName());
		System.out.println("*******************Price()="+vo.getItems().getPrice());
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		ItemsMapper mapper = openSession.getMapper(ItemsMapper.class);
		List<Items> list = mapper.selectByVo(vo);
		return list;
	}
	@Override
	public Items findItemsById(Integer id) throws Exception {
		Items item = itemsMapper.selectByPrimaryKey(id);
		return item;
	}
	@Override
	public void updateItems(Items item) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(item);
	}
}
