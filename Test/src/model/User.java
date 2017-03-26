package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="users_id")
	private int usersId;

	private String remark1;

	private String remark2;

	private String remark3;

	@Column(name="users_name")
	private String usersName;

	//bi-directional many-to-one association to CrmCustomer
	@OneToMany(mappedBy="user")
	private Set<CrmCustomer> crmCustomers;

	public User() {
	}

	public int getUsersId() {
		return this.usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getUsersName() {
		return this.usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public Set<CrmCustomer> getCrmCustomers() {
		return this.crmCustomers;
	}

	public void setCrmCustomers(Set<CrmCustomer> crmCustomers) {
		this.crmCustomers = crmCustomers;
	}

	public CrmCustomer addCrmCustomer(CrmCustomer crmCustomer) {
		getCrmCustomers().add(crmCustomer);
		crmCustomer.setUser(this);

		return crmCustomer;
	}

	public CrmCustomer removeCrmCustomer(CrmCustomer crmCustomer) {
		getCrmCustomers().remove(crmCustomer);
		crmCustomer.setUser(null);

		return crmCustomer;
	}

}