package com.cdsxt.po;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 多方
 *
 */
@Entity  //表示需要进行持久化管理
@Table(name="t_student")
public class Student { 
	@Id
	@SequenceGenerator(name="seqStudent",sequenceName="seq_test_student")
	@GeneratedValue(generator="seqStudent")
    private int id;  
    private String name;  
    private Date createTime;  
    @ManyToOne
    @JoinColumn(name="cid")
    private Classes classes;  
    public Date getCreateTime() {  
        return createTime;  
    }  
      
    public Student() {  
    }  

    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", createTime=" + createTime + ", classes=" + classes.getName() + "]";
	}

	public Student(int id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
    public void setCreateTime(Date createTime) {  
        this.createTime = createTime;  
    }  
      
    public Classes getClasses() {  
        return classes;  
    }  
    public void setClasses(Classes classes) {  
        this.classes = classes;  
    }  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}