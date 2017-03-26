package com.cdsxt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class DownloadAction {
	
	private InputStream input;
	
	
	public String download(){
		try {
			this.input = new FileInputStream(new File("e:/美女.jpg"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "down";
	}

	//操，此法是框架内置调用，不一定需要有：private InputStream filename;从服务器到页面，只需要有get方法即可；
	//同时在struts.xml中一样可以使用EL表达式取到filename。
	public String getFilename(){ 
		return new String("美女1号.jpg".getBytes(Charset.forName("GBK")),Charset.forName("ISO8859-1"));
	}
	
	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

}
