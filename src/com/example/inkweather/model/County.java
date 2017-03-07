package com.example.inkweather.model;

public class County {
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
	 * @return the coutny_name
	 */
	public String getCoutny_name() {
		return coutny_name;
	}
	/**
	 * @param coutny_name the coutny_name to set
	 */
	public void setCoutny_name(String coutny_name) {
		this.coutny_name = coutny_name;
	}
	/**
	 * @return the ountny_code
	 */
	public String getOuntny_code() {
		return ountny_code;
	}
	/**
	 * @param ountny_code the ountny_code to set
	 */
	public void setOuntny_code(String ountny_code) {
		this.ountny_code = ountny_code;
	}
	private int id;
     private String coutny_name;
     private String ountny_code;
}
