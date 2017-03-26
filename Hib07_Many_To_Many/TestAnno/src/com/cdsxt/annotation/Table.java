package com.cdsxt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明一个注解
/**
 * @interface
 * 
   TYPE; 使用在类上面
  
   FIELD; 属性
  
   METHOD;方法
  
   PARAMETER; 参数
  
   CONSTRUCTOR; 构造器
  
   LOCAL_VARIABLE; 局部变量
  
   ANNOTATION_TYPE; 注解上
  
   PACKAGE; 包
  
   TYPE_PARAMETER; 类型参数
  
   TYPE_USE;
   
   
   
   保留策略
   	Class  class级别
   	
   	source  源码级别
   	
   	RUNTIME   运行级别  如果要解析 就需要使用该级别
 * 
 * 
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

	//声明属性
	//类型  属性名()  default 默认值;
	String name() default "";
}
