package com.cdsxt.po;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;


/**
 * byte[Byte]   <====> number(3)
 * short        <====> number(5)
 * int[Integer] <====> number(10)
 * char         <====> char(1)
 * long[Long]	<====> number(19)
 * double       <====> float
 * float        <====> float  可以在后台将 number转换为double或者float
 * String		<====> varchar2(255)
 * Date[SQL]	<====> Date
 * Date[Util]	<====> Date
 * Clob			<====> clob
 * Blob			<====> blob
 *  :BLOB和CLOB都是大字段类型，BLOB是按二进制来存储的，而CLOB是可以直接存储文字的。其实两个是可以互换的的，或者可以直接用LOB字段代替这两个。但是为了更好的管理ORACLE数据库，通常像图片、文件、音乐等信息就用BLOB字段来存储，先将文件转为二进制再存储进去。而像文章或者是较长的文字，就用CLOB存储，这样对以后的查询更新存储等操作都提供很大的方便。
 * 
 * 
 * @author Administrator
 *
 */
public class DataTypes {
	
	//测试数据类型对应
	
	private Integer id;
	
	private byte testByte;
	private short testShort;
	private int testInt;
	private Integer testInteger;
	private Double testDouble;
	//在Oracle中 没有 boolean值  使用代替方式  number(1);也没有object对应的类型
	private Boolean testBool;
	
	private long testLong;
	private float testFloat;
	
	private String testString;
	private char testChar;
	
	private Clob testClob;
	private Blob testBlob;
	
	private Date testSqlDate;
	private java.util.Date testUtilDate;
	
	private Object testObject;

	public byte getTestByte() {
		return testByte;
	}

	public void setTestByte(byte testByte) {
		this.testByte = testByte;
	}

	public short getTestShort() {
		return testShort;
	}

	public void setTestShort(short testShort) {
		this.testShort = testShort;
	}

	public int getTestInt() {
		return testInt;
	}

	public void setTestInt(int testInt) {
		this.testInt = testInt;
	}

	public Integer getTestInteger() {
		return testInteger;
	}

	public void setTestInteger(Integer testInteger) {
		this.testInteger = testInteger;
	}

	public Double getTestDouble() {
		return testDouble;
	}

	public void setTestDouble(Double testDouble) {
		this.testDouble = testDouble;
	}

	public Boolean isTestBool() {
		return testBool;
	}

	public void setTestBool(Boolean testBool) {
		this.testBool = testBool;
	}

	public long getTestLong() {
		return testLong;
	}

	public void setTestLong(long testLong) {
		this.testLong = testLong;
	}

	public float getTestFloat() {
		return testFloat;
	}

	public void setTestFloat(float testFloat) {
		this.testFloat = testFloat;
	}

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public char getTestChar() {
		return testChar;
	}

	public void setTestChar(char testChar) {
		this.testChar = testChar;
	}

	public Clob getTestClob() {
		return testClob;
	}

	public void setTestClob(Clob testClob) {
		this.testClob = testClob;
	}

	public Blob getTestBlob() {
		return testBlob;
	}

	public void setTestBlob(Blob testBlob) {
		this.testBlob = testBlob;
	}

	public Date getTestSqlDate() {
		return testSqlDate;
	}

	public void setTestSqlDate(Date testSqlDate) {
		this.testSqlDate = testSqlDate;
	}

	public java.util.Date getTestUtilDate() {
		return testUtilDate;
	}

	public void setTestUtilDate(java.util.Date testUtilDate) {
		this.testUtilDate = testUtilDate;
	}

	public Object getTestObject() {
		return testObject;
	}

	public void setTestObject(Object testObject) {
		this.testObject = testObject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
