package com.ignite.beans;

public class Purchase_Det {

	Integer pd_id;
	String pd_order;
	String pd_type;
	Integer pd_qty;
	String pd_vendor;
	String pd_date;
	String pd_ddate;
	String pd_status;
	String isactive;
	public Purchase_Det() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase_Det(Integer pd_id, String pd_order, String pd_type, Integer pd_qty, String pd_vendor, String pd_date,
			String pd_ddate, String pd_status, String isactive) {
		super();
		this.pd_id = pd_id;
		this.pd_order = pd_order;
		this.pd_type = pd_type;
		this.pd_qty = pd_qty;
		this.pd_vendor = pd_vendor;
		this.pd_date = pd_date;
		this.pd_ddate = pd_ddate;
		this.pd_status = pd_status;
		this.isactive = isactive;
	}
	public Integer getPd_id() {
		return pd_id;
	}
	public void setPd_id(Integer pd_id) {
		this.pd_id = pd_id;
	}
	public String getPd_order() {
		return pd_order;
	}
	public void setPd_order(String pd_order) {
		this.pd_order = pd_order;
	}
	public String getPd_type() {
		return pd_type;
	}
	public void setPd_type(String pd_type) {
		this.pd_type = pd_type;
	}
	public Integer getPd_qty() {
		return pd_qty;
	}
	public void setPd_qty(Integer pd_qty) {
		this.pd_qty = pd_qty;
	}
	public String getPd_vendor() {
		return pd_vendor;
	}
	public void setPd_vendor(String pd_vendor) {
		this.pd_vendor = pd_vendor;
	}
	public String getPd_date() {
		return pd_date;
	}
	public void setPd_date(String pd_date) {
		this.pd_date = pd_date;
	}
	public String getPd_ddate() {
		return pd_ddate;
	}
	public void setPd_ddate(String pd_ddate) {
		this.pd_ddate = pd_ddate;
	}
	public String getPd_status() {
		return pd_status;
	}
	public void setPd_status(String pd_status) {
		this.pd_status = pd_status;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "Purchase_Det [pd_id=" + pd_id + ", pd_order=" + pd_order + ", pd_type=" + pd_type + ", pd_qty=" + pd_qty
				+ ", pd_vendor=" + pd_vendor + ", pd_date=" + pd_date + ", pd_ddate=" + pd_ddate + ", pd_status="
				+ pd_status + ", isactive=" + isactive + "]";
	}
		
	

}


