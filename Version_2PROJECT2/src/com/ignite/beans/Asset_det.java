package com.ignite.beans;

public class Asset_det {
	
	Integer ad_id;
	String ad_name;
	String ad_type;
	String ad_class;
	String isactive;
	public Asset_det() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Asset_det(String ad_name, String ad_type, String ad_class, String isactive) {
		super();
		this.ad_name = ad_name;
		this.ad_type = ad_type;
		this.ad_class = ad_class;
		this.isactive = isactive;
	}
	public Integer getAd_id() {
		return ad_id;
	}
	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_type() {
		return ad_type;
	}
	public void setAd_type(String ad_type) {
		this.ad_type = ad_type;
	}
	public String getAd_class() {
		return ad_class;
	}
	public void setAd_class(String ad_class) {
		this.ad_class = ad_class;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "Asset_det [ad_id=" + ad_id + ", ad_name=" + ad_name + ", ad_type=" + ad_type + ", ad_class="
				+ ad_class + ", isactive=" + isactive + "]";
	}
	


}
