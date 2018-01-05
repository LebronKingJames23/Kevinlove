package cn.crm.pojo;

import java.util.HashSet;
import java.util.Set;

public class Dict {
	private Integer lid;
	private String lname;
	private String ltype;
	private Set<Customer> customer= new HashSet<Customer>();
	
	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLtype() {
		return ltype;
	}
	public void setLtype(String ltype) {
		this.ltype = ltype;
	}
	@Override
	public String toString() {
		return "Dict [lid=" + lid + ", lname=" + lname + ", ltype=" + ltype + ", customer=" + customer + "]";
	}
	

}
