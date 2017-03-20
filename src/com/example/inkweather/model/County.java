package com.example.inkweather.model;

public class County {
	private int id;
	private String coutny_name;
	private String ountny_code;
	private int cityId;

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
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
	 * @return the coutny_name
	 */
	public String getCoutnyName() {
		return coutny_name;
	}

	/**
	 * @param coutny_name
	 *            the coutny_name to set
	 */
	public void setCoutnyName(String coutny_name) {
		this.coutny_name = coutny_name;
	}

	/**
	 * @return the ountny_code
	 */
	public String getCuntnyCode() {
		return ountny_code;
	}

	/**
	 * @param ountny_code
	 *            the ountny_code to set
	 */
	public void setCuntnyCode(String ountny_code) {
		this.ountny_code = ountny_code;
	}
}
