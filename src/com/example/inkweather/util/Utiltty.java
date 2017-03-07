package com.example.inkweather.util;

import com.example.inkweather.model.City;
import com.example.inkweather.model.County;
import com.example.inkweather.model.InkWeatherDB;
import com.example.inkweather.model.Province;

import android.text.TextUtils;

public class Utiltty {
	public synchronized static boolean handleProvincesResponse(InkWeatherDB inkWeatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvince_code(array[0]);
					province.setProvince_name(array[1]);
					inkWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}

	public synchronized static boolean handleCitiesResponse(InkWeatherDB inkWeatherDB, String reponse) {
		if (TextUtils.isEmpty(reponse)) {
			String[] allCitise = reponse.split(",");
			if (allCitise != null && allCitise.length > 0) {
				for (String c : allCitise) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCity_code(array[0]);
					city.setCity_name(array[1]);
					inkWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}

	public synchronized static boolean handleCountiesResponse(InkWeatherDB inkWeatherDB, String reponse) {
		if (!TextUtils.isEmpty(reponse)) {
			String[] allCounties = reponse.split(",");
			if (allCounties != null && allCounties.length > 0) {
				for (String c : allCounties) {
					String[] array = c.split("\\|");
					County county = new County();
					county.setOuntny_code(array[0]);
					county.setCoutny_name(array[1]);
					inkWeatherDB.saveCounty(county);
				}
			}
			return true;
		}
		return false;

	}
}
