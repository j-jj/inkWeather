package com.example.inkweather.model;

public class Province {
	private int id;
	private String province_name;
	private String province_code;

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
	public String getProvinceName() {
		return province_name;
	}
	/**
	 * @param province_name the province_name to set
	 */
	public void setProvinceName(String province_name) {
		this.province_name = province_name;
	}
	/**
	 * @return the province_code
	 */
	public String getProvinceCode() {
		return province_code;
	}
	/**
	 * @param province_code the province_code to set
	 */
	public void setProvinceCode(String province_code) {
		this.province_code = province_code;
	}

}
