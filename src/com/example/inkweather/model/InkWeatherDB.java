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
			values.put("province_name", province.getProvince_name());
			values.put("province_code", province.getProvince_code());
			db.insert("Province", null, values);
		}
	}

	public List<Province> loadProvince() {
		List<Province> lists = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province = new Province();
				province.setId(cursor.getColumnIndex("id"));
				province.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvince_code(cursor.getString(cursor.getColumnIndex("province_code")));
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
			ContentValues contentValue = new ContentValues();
			contentValue.put("city_name", city.getCity_name());
			contentValue.put("city_code", city.getCity_code());
			db.insert("City", null, contentValue);
		}
	}

	public List<City> loadCity() {
		List<City> lists = new ArrayList<City>();
		Cursor cursor = db.query("City", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			City city = new City();
			do {
				city.setId(cursor.getColumnIndex("id"));
				city.setCity_name(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCity_code(cursor.getString(cursor.getColumnIndex("city_code")));
				lists.add(city);
			} while (cursor.moveToNext());
			if (cursor != null) {
				cursor.close();
			}
		}
		return lists;
	}

	public void saveCounty(County county) {
		if (county != null) {
			ContentValues values = new ContentValues();
			values.put("coutny_name", county.getCoutny_name());
			values.put("ountny_code", county.getOuntny_code());
			db.insert("County", null, values);
		}
	}

	public List<County> loadCounty() {
		List<County> lists = new ArrayList<County>();
		Cursor cursor = db.query("County", null, null, null, null, null, null);
		if (cursor != null) {
			County county = new County();
			do {
				county.setId(cursor.getColumnIndex("id"));
				county.setCoutny_name(cursor.getString(cursor.getColumnIndex("coutny_name")));
				county.setOuntny_code(cursor.getString(cursor.getColumnIndex("ountny_code")));
				lists.add(county);
			} while (cursor.moveToNext());
			if (cursor != null) {
				cursor.close();
			}
		}
		return lists;
	}
}
