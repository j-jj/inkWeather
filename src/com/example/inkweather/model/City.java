package com.example.inkweather.model;

public class City {
	private int id;
	private String city_name;
	private String city_code;
	private int provinceId;

	/**
	 * @return the provinceId
	 */
	public int getProvinceId() {
		return provinceId;
	}

	/**
	 * @param provinceId
	 *            the provinceId to set
	 */
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city_name
	 */
	public String getCityName() {
		return city_name;
	}

	/**
	 * @param city_name
	 *            the city_name to set
	 */
	public void setCityName(String city_name) {
		this.city_name = city_name;
	}

	/**
	 * @return the city_code
	 */
	public String getCityCode() {
		return city_code;
	}

	/**
	 * @param city_code
	 *            the city_code to set
	 */
	public void setCityCode(String city_code) {
		this.city_code = city_code;
	}

}
