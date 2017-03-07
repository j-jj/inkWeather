package com.example.inkweather.model;

public class Province {

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the province_name
	 */
	public String getProvince_name() {
		return province_name;
	}
	/**
	 * @param province_name the province_name to set
	 */
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	/**
	 * @return the province_code
	 */
	public String getProvince_code() {
		return province_code;
	}
	/**
	 * @param province_code the province_code to set
	 */
	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}
	private int id;
	private String province_name;
	private String province_code;

}
