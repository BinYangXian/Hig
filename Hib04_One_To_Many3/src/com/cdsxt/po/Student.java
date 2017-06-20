package com.cdsxt.po;

/**
 * 多方   在多方持有外键
 *
 */
public class Student {
	
	private Integer stuId;
	private String stuName;
	private String age;
	private Integer score;
	private ClassInfo info;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public ClassInfo getInfo() {
		return info;
	}

	public void setInfo(ClassInfo info) {
		this.info = info;
	}

}
