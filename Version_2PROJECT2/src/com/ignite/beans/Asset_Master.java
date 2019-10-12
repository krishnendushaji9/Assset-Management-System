package com.ignite.beans;

public class Asset_Master {
 
	Integer am_id;
	String am_type;
	String am_make;
	String am_model;
	String am_snumber;
	String am_myear;
	String am_pdate;
	String am_warranty;
	String am_from;
	String am_to;
	String isactive;
	public Asset_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asset_Master(Integer am_id, String am_type, String am_make, String am_model, String am_snumber,
			String am_myear, String am_pdate, String am_warranty, String am_from, String am_to, String isactive) {
		super();
		this.am_id = am_id;
		this.am_type = am_type;
		this.am_make = am_make;
		this.am_model = am_model;
		this.am_snumber = am_snumber;
		this.am_myear = am_myear;
		this.am_pdate = am_pdate;
		this.am_warranty = am_warranty;
		this.am_from = am_from;
		this.am_to = am_to;
		this.isactive = isactive;
	}
	public Integer getAm_id() {
		return am_id;
	}
	public void setAm_id(Integer am_id) {
		this.am_id = am_id;
	}
	public String getAm_type() {
		return am_type;
	}
	public void setAm_type(String am_type) {
		this.am_type = am_type;
	}
	public String getAm_make() {
		return am_make;
	}
	public void setAm_make(String am_make) {
		this.am_make = am_make;
	}
	public String getAm_model() {
		return am_model;
	}
	public void setAm_model(String am_model) {
		this.am_model = am_model;
	}
	public String getAm_snumber() {
		return am_snumber;
	}
	public void setAm_snumber(String am_snumber) {
		this.am_snumber = am_snumber;
	}
	public String getAm_myear() {
		return am_myear;
	}
	public void setAm_myear(String am_myear) {
		this.am_myear = am_myear;
	}
	public String getAm_pdate() {
		return am_pdate;
	}
	public void setAm_pdate(String am_pdate) {
		this.am_pdate = am_pdate;
	}
	public String getAm_warranty() {
		return am_warranty;
	}
	public void setAm_warranty(String am_warranty) {
		this.am_warranty = am_warranty;
	}
	public String getAm_from() {
		return am_from;
	}
	public void setAm_from(String am_from) {
		this.am_from = am_from;
	}
	public String getAm_to() {
		return am_to;
	}
	public void setAm_to(String am_to) {
		this.am_to = am_to;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "Asset_Master [am_id=" + am_id + ", am_type=" + am_type + ", am_make=" + am_make + ", am_model="
				+ am_model + ", am_snumber=" + am_snumber + ", am_myear=" + am_myear + ", am_pdate=" + am_pdate
				+ ", am_warranty=" + am_warranty + ", am_from=" + am_from + ", am_to=" + am_to + ", isactive="
				+ isactive + "]";
	}
	
	

}


