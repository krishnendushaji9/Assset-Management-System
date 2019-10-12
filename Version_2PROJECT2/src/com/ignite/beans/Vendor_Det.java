package com.ignite.beans;

public class Vendor_Det {

	Integer vd_id;
	String vd_name;
	String vd_type;
	String vd_atype;
	String vd_from;
	String vd_to;
	String vd_addr;
	String isactive;
	
	public Vendor_Det(String vd_name, String vd_type, String vd_atype, String vd_from, String vd_to, String vd_addr,
			String isactive) {
		super();
		this.vd_name = vd_name;
		this.vd_type = vd_type;
		this.vd_atype = vd_atype;
		this.vd_from = vd_from;
		this.vd_to = vd_to;
		this.vd_addr = vd_addr;
		this.isactive = isactive;
	}
	
	public Vendor_Det() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor_Det(Integer vd_id, String vd_name, String vd_type, String vd_atype, String vd_from, String vd_to,
			String vd_addr, String isactive) {
		super();
		this.vd_id = vd_id;
		this.vd_name = vd_name;
		this.vd_type = vd_type;
		this.vd_atype = vd_atype;
		this.vd_from = vd_from;
		this.vd_to = vd_to;
		this.vd_addr = vd_addr;
		this.isactive = isactive;
	}
	public Integer getVd_id() {
		return vd_id;
	}
	public void setVd_id(Integer vd_id) {
		this.vd_id = vd_id;
	}
	public String getVd_name() {
		return vd_name;
	}
	public void setVd_name(String vd_name) {
		this.vd_name = vd_name;
	}
	public String getVd_type() {
		return vd_type;
	}
	public void setVd_type(String vd_type) {
		this.vd_type = vd_type;
	}
	public String getVd_atype() {
		return vd_atype;
	}
	public void setVd_atype(String vd_atype) {
		this.vd_atype = vd_atype;
	}
	public String getVd_from() {
		return vd_from;
	}
	public void setVd_from(String vd_from) {
		this.vd_from = vd_from;
	}
	public String getVd_to() {
		return vd_to;
	}
	public void setVd_to(String vd_to) {
		this.vd_to = vd_to;
	}
	public String getVd_addr() {
		return vd_addr;
	}
	public void setVd_addr(String vd_addr) {
		this.vd_addr = vd_addr;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "Vendor_Det [vd_id=" + vd_id + ", vd_name=" + vd_name + ", vd_type=" + vd_type + ", vd_atype=" + vd_atype
				+ ", vd_from=" + vd_from + ", vd_to=" + vd_to + ", vd_addr=" + vd_addr + ", isactive=" + isactive + "]";
	}
	
}
