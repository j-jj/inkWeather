package com.example.inkweather.util;

import com.example.inkweather.model.City;
import com.example.inkweather.model.County;
import com.example.inkweather.model.InkWeatherDB;
import com.example.inkweather.model.Province;

import android.text.TextUtils;

public class Utility {
	public synchronized static boolean handleProvincesResponse(InkWeatherDB inkWeatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					inkWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}

	public synchronized static boolean handleCitiesResponse(InkWeatherDB inkWeatherDB, String response, int provinceId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCitise = response.split(",");
			if (allCitise != null && allCitise.length > 0) {
				for (String c : allCitise) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					inkWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}

	public synchronized static boolean handleCountiesResponse(InkWeatherDB inkWeatherDB, String response, int cityId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCounties = response.split(",");
			if (allCounties != null && allCounties.length > 0) {
				for (String c : allCounties) {
					String[] array = c.split("\\|");
					County county = new County();
					county.setCuntnyCode(array[0]);
					county.setCoutnyName(array[1]);
					county.setCityId(cityId);
					inkWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;

	}
}
