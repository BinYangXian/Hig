package com.cdsxt.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.cdsxt.po.Users;

public class UploadAction {
	
	//文件 临时文件
	private File file;
	//得到文件名  文件属性名+FileName
	private String fileFileName;
	//得到文件类型
	private String fileContentType;
	
	private Users users;
	
	public String upload(){
		
		try {
			FileUtils.copyFile(file, new File("e:/"+fileFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(this.users);
		return "upload";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	

}
