package cn.itheima.exception;

//自定义异常类,用来处理自定义异常
public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261900786875273698L;
	//保存异常信息
	private String  message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
