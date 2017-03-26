package com.cdsxt;

import java.lang.reflect.Field;

import com.cdsxt.annotation.Column;
import com.cdsxt.annotation.Id;
import com.cdsxt.annotation.Table;

public class Parser {
	
	public static void main(String[] args) {
		//解析类里面的注解
		//得到class的各个部分[class字节码、filed、构造器、方法、...]
		//分别判断各个部分上面是否包含相应的注解  如果有 则处理 否则就不处理
		
		Class<Person> clazz = Person.class;
		
		StringBuilder sb = new StringBuilder("create table ");
		
		//判断是否有给定注解
		if(clazz.isAnnotationPresent(Table.class)){
			//得到注解
			Table table = clazz.getAnnotation(Table.class);
			//得到注解中的配置信息
			String tableName = table.name();
			
			sb.append(tableName).append("(");
			
		}
		//得到所有的属性
		Field []fields = clazz.getDeclaredFields();
		for(Field field:fields){
			//解析里面的所有的 类型  和列
			String columnName = "";
			if(field.isAnnotationPresent(Column.class)){
				Column column = field.getAnnotation(Column.class);
				//得到列名
				columnName = column.name();
			}
			
			if(columnName.trim().length()<1){
				//如果 columnName是空的  就得到  属性的名称
				columnName = field.getName();
			}
			
			sb.append(columnName).append(" ");
			Class<?> type = field.getType();
			if(type == String.class){
				sb.append(" varchar2(255) ");
			}else if(type == int.class || type == Integer.class){
				sb.append(" number(10) ");
			}
			
			if(field.isAnnotationPresent(Id.class)){
				sb.append(" primary key");
			}
			
			sb.append(",");
			
		}
		
		//删除多余的,
		sb.deleteCharAt(sb.length()-1);
		
		sb.append(")");
		
		System.out.println(sb.toString());
	}

}
