package com.example.inkweather.model;

import java.util.ArrayList;
import java.util.List;

import com.example.inkweather.db.InkWeatherOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class InkWeatherDB {

	public static final String BD_NAME = "ink_weather";

	public static final int VERSION = 1;

	private static InkWeatherDB inkWeatherDB;

	private SQLiteDatabase db;

	private InkWeatherDB(Context context) {
		InkWeatherOpenHelper dbHelper = new InkWeatherOpenHelper(context, BD_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}

	public synchronized static InkWeatherDB getInStance(Context context) {
		if (inkWeatherDB == null) {
			inkWeatherDB = new InkWeatherDB(context);
		}
		return inkWeatherDB;
	}

	public void saveProvince(Province province) {
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}

	public List<Province> loadProvince() {
		List<Province> lists = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				lists.add(province);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return lists;
	}

	public void saveCity(City city) {
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}
	}

	public List<City> loadCities(int provinceId) {
		List<City> lists = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_id = ?", new String[] { String.valueOf(provinceId) }, null,
				null, null);
		if (cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setProvinceId(provinceId);
				lists.add(city);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return lists;
	}

	public void saveCounty(County county) {
		if (county != null) {
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCoutnyName());
			values.put("county_code", county.getCuntnyCode());
			values.put("city_id", county.getCityId());
			db.insert("County", null, values);
		}
	}

	public List<County> loadCounty(int cityId) {
		List<County> lists = new ArrayList<County>();
		Cursor cursor = db.query("County", null, "city_id = ?", new String[] { String.valueOf(cityId) }, null, null,
				null);

		if (cursor.moveToFirst()) {
			do {
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCoutnyName(cursor.getString(cursor.getColumnIndex("county_name")));
				county.setCuntnyCode(cursor.getString(cursor.getColumnIndex("county_code")));
				county.setCityId(cityId);
				lists.add(county);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return lists;
	}
}
