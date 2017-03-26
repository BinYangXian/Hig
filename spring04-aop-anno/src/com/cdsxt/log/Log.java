package com.cdsxt.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {
	
	
	@Before("execution(public * com.cdsxt.service.impl.*.delete(..))")
	public void log(JoinPoint jp){
		System.out.println("记录日志");
	}
	@Around("execution(public * com.cdsxt.service.impl.*.save*(..)) || execution(public * com.cdsxt.service.impl.*.delete*(..))")
	public void time(ProceedingJoinPoint jp){
		System.out.println(jp.getKind());
		System.out.println(jp.getTarget());
		System.out.println(jp.getThis());
		System.out.println(jp.getArgs());
		System.out.println(jp.getSignature());
		System.out.println(jp.getSignature().getModifiers());
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getStaticPart());
		
		
		
		System.out.println(jp);
		
		long start = System.currentTimeMillis();
		
		try {
			//显示调用方法
			jp.proceed(jp.getArgs());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
}
