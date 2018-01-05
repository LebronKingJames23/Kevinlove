package cn.crm.pojo;

public class Visit {
private Integer visitid;
private String visitaddress;
private String visitcontent;
private User user;
private Customer customer;
public Integer getVisitid() {
	return visitid;
}
public void setVisitid(Integer visitid) {
	this.visitid = visitid;
}
public String getVisitaddress() {
	return visitaddress;
}
public void setVisitaddress(String visitaddress) {
	this.visitaddress = visitaddress;
}
public String getVisitcontent() {
	return visitcontent;
}
public void setVisitcontent(String visitcontent) {
	this.visitcontent = visitcontent;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
@Override
public String toString() {
	return "Visit [visitid=" + visitid + ", visitaddress=" + visitaddress + ", visitcontent=" + visitcontent + "]";
}



}
