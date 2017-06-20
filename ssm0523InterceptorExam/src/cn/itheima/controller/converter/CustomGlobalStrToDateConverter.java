package cn.itheima.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * S - source:源
 * T - target:目标
 * @author zj
 *
 */
public class CustomGlobalStrToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
class SingleTon{
	private static SingleTon singleTon;
	private SingleTon(){
		super();
	}
	public synchronized SingleTon getSingleTon(){
		if(singleTon==null){
			return new SingleTon();
		}
		return singleTon;
	}
}
class SingleTon2{
	private static SingleTon2 singleTon2=new SingleTon2();
	private SingleTon2(){
		super();
	}
	public synchronized SingleTon2 getSingleTon2(){
			return singleTon2;
	}
}
class SingleTon3{
	private SingleTon3(){
		super();
	}
	public static class SingleTonFac{
		SingleTon3 singleTon3=new SingleTon3();
		public SingleTon3 getSingleTon3(){
			return singleTon3;
		}
	}
}
