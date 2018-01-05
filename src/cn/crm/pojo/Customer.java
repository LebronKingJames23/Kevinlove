package cn.crm.pojo;

import java.util.HashSet;
import java.util.Set;


public class Customer {
private Integer cid;
private String custName;
private String custSource;
private String custPhone;
private String custMobile;
private String custAddress;
private String custZip;
private String custlevel;
private Dict dict;



	//@JSONField(serialize=false)eayui用就打开
private Set<LinkMan> setlinkeman=new HashSet<LinkMan>();
//@JSONField(serialize=false)
private Set<Visit> setvisit=new HashSet<Visit>();


public Set<Visit> getSetvisit() {
	return setvisit;
}
public void setSetvisit(Set<Visit> setvisit) {
	this.setvisit = setvisit;
}
public Set<LinkMan> getSetlinkeman() {
	return setlinkeman;
}
public void setSetlinkeman(Set<LinkMan> setlinkeman) {
	this.setlinkeman = setlinkeman;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getCustSource() {
	return custSource;
}
public void setCustSource(String custSource) {
	this.custSource = custSource;
}
public String getCustPhone() {
	return custPhone;
}
public void setCustPhone(String custPhone) {
	this.custPhone = custPhone;
}
public String getCustMobile() {
	return custMobile;
}
public void setCustMobile(String custMobile) {
	this.custMobile = custMobile;
}
public String getCustAddress() {
	return custAddress;
}
public void setCustAddress(String custAddress) {
	this.custAddress = custAddress;
}
public String getCustZip() {
	return custZip;
}
public void setCustZip(String custZip) {
	this.custZip = custZip;
}
	public String getCustlevel() {
		return custlevel;
	}

	public void setCustlevel(String custlevel) {
		this.custlevel = custlevel;
	}
	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

}
