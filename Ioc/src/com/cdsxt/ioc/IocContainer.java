package com.cdsxt.ioc;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.cdsxt.config.Bean;
import com.cdsxt.config.Beans;
import com.cdsxt.config.Property;

public class IocContainer {

	private static final Map<String,Object> cache = new HashMap<>();
	
	private IocContainer(){
		try {
			//做初始化操作
			//创建JaxbContext
			
			//解析xml
			JAXBContext context = JAXBContext.newInstance(Beans.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Beans root = (Beans)unmarshaller.unmarshal(new File("src/beans.xml"));
			if(root==null){
				throw new IllegalArgumentException("参数错误");
			}
			//得到所有的配置对象
			List<Bean> beans = root.getBeans();
			//将得到的所有的class字符串解析为Class对象   并且通过反射创建对象
			for(Bean bean:beans){
				//得到id
				String id = bean.getId();
				//得到class字符串
				String clazz = bean.getClazz();
				//加载为Class对象
				Class<?> clz = Class.forName(clazz);
				//将对象放入到该容器中进行缓存Map<String,Object>
				
				//先判断   如果缓存中已经存在 则直接报错  
				if(cache.containsKey(id)){
					throw new IllegalArgumentException(String.format("给定的%s对象已经存在!", id));
				}
				cache.put(id, clz.newInstance());
			}
			//再解析关系
			
			for(Bean bean:beans){
				//看一下该bean标签下是否有  property标签
				List<Property> property = bean.getProperty();
				if(property.isEmpty()){
					continue;
				}
				//得到id
				String id = bean.getId();
				//目标类
				Object target = cache.get(id);
				if(target==null){
					throw new Exception("给定的对象是空的");
				}
				
				for(Property prop:property){
					String name = prop.getName();
					String ref = prop.getRef();
					
					//得到要引用的对象
					Object refObj = cache.get(ref);
					if(refObj == null){
						throw new Exception("引用的对象不存在");
					}
					Class<?> clazz = target.getClass();
					//主要用于得到 setter方法的参数类型
					Field field = clazz.getDeclaredField(name);
					//构建setter方法
					String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
					//得到方法对象
					Method method = clazz.getMethod(methodName, field.getType());
					//执行方法
					method.invoke(target, refObj);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static class Creator{
		private static IocContainer instance = new IocContainer();
	}
	
	public static IocContainer getInstance(){
		return Creator.instance;
	}
	
	public Object getBean(String id){
		return cache.get(id);
	}
}
