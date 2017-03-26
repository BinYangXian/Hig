package com.cdsxt.po;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="test_class_info")
public class ClassInfo {
	
	@Id
	@SequenceGenerator(name="seqInfo",sequenceName="seq_test_class_info")
	@GeneratedValue(generator="seqInfo")
	private Integer cid;
	
	private String cname;
	
	@Transient //表示临时的
	private Integer cno;
	
	/**
	 * <set name="" inverse="">
	 * 		<key column=""></key>
	 * 		<one-to-many class="">
	 * </set>
	 * 
	 * 
	 * 如果没有 写mappedBy  这在一方会产生一张新的关系表  用于一方维护关系   但是我不需要  所有需要写上mappedBy
	 * 
	 * 如果写了 mappedBy属性  同时有cascade属性  则一方会按照cascade对集合进行相应的操作
	 * 
	 * cascade
	 * 		CascadeType.ALL  全部
	 * 		CascadeType.MERGE  更新
	 * 		CascadeType.PERSIST  保存
	 * 		CascadeType.REFRESH  刷新
	 * 		CascadeType.REMOVE  删除
	 * 		CascadeType.DETACH  游离（基本不用）
	 * 
	 * 
	 * 集合默认是懒加载的
	 */
	@OneToMany(cascade={CascadeType.ALL},mappedBy="info",fetch=FetchType.EAGER)
	private Set<Student> students;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
