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
@Entity
@Table(name="t_classes")
public class Classes {  
	@Id
	@SequenceGenerator(name="seqInfo",sequenceName="seq_test_class_info")
	@GeneratedValue(generator="seqInfo")
    private int cid;  
    private String name;  
    @OneToMany(cascade=CascadeType.ALL,mappedBy="classes") 
    private Set<Student> students;  
      
    @Override
	public String toString() {
		return "Classes [cid=" + cid + ", name=" + name + ", students=" + students + "]";
	}
	public Set<Student> getStudents() {  
        return students;  
    }  
    public void setStudents(Set<Student> students) {  
        this.students = students;  
    }  
 
    public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}  