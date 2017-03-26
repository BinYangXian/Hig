package com.cdsxt;

import com.cdsxt.po.Person;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTests {

	public static void main(String[] args) {
		
		//LRU  淘汰最长时间未被使用的元素
		//LFU  淘汰在一定时间内使用次数最少的元素
		//FIFO 先进先出
		//测试缓存
		//测试步骤
		//创建缓存管理器
		CacheManager manager = CacheManager.create();
		//从缓存管理器里面得到 对应的缓存单元
		
		Cache cache = manager.getCache("myCache");

		System.out.println(cache);
		//将数据包装为可以存储的元素  内部实现  map
		Person p1 = new Person("p1");
		Person p2 = new Person("p2");
		Person p3 = new Person("p3");
		Person p4 = new Person("p4");
		System.out.println(p1);
		//创建元素
		Element e1 = new Element("p1", p1);
		Element e2 = new Element("p2", p2);
		Element e3 = new Element("p3", p3);
		Element e4 = new Element("p4", p4);
		cache.put(e2);
		cache.put(e1);
		cache.put(e3);
		
		cache.get("p2").getValue();
		cache.get("p2").getValue();
		cache.get("p2").getValue();
		cache.get("p2").getValue();
		
		cache.get("p1").getValue();
		cache.get("p1").getValue();
		
		cache.get("p3").getValue();
		
		cache.put(e4);
		
		//System.out.println(cache.get("p1").getValue());
		
		//将元素存入缓存单元中
	}
}
