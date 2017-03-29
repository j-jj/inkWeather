package com.example.inkweather.activity;

import com.example.inkweather.R;
import com.example.inkweather.util.HttpCallbackListener;
import com.example.inkweather.util.HttpUtil;
import com.example.inkweather.util.Utility;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class WeatherActivity extends Activity implements OnClickListener {
	private LinearLayout weatherInfoLayout;
	private TextView cityNameText;
	private TextView publishText;
	private TextView weatherDespText;
	private TextView temp1Text;
	private TextView temp2Text;
	private TextView currentDateText;
	private Button switchCityBtn;
	private Button refreshBtn;
	private RelativeLayout weatherLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		init();
	}

	private void init() {
		weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
		cityNameText = (TextView) findViewById(R.id.city_name);
		weatherDespText = (TextView) findViewById(R.id.weather_desp);
		temp1Text = (TextView) findViewById(R.id.temp1);
		publishText = (TextView) findViewById(R.id.publish_text);
		temp2Text = (TextView) findViewById(R.id.temp2);
		currentDateText = (TextView) findViewById(R.id.current_date);
		switchCityBtn = (Button) findViewById(R.id.switch_city);
		switchCityBtn.setOnClickListener(this);
		refreshBtn = (Button) findViewById(R.id.refresh_city);
		refreshBtn.setOnClickListener(this);
		weatherLayout = (RelativeLayout) findViewById(R.id.weather_layout);
		String countyCode = getIntent().getStringExtra("county_Code");
		if (!TextUtils.isEmpty(countyCode)) {
			publishText.setText("ͬ����...");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			qyertWeatherCode(countyCode);
		} else {
			showWeather();
		}
	}

	/* ��ѯ�ؼ���������Ӧ���������� */
	private void qyertWeatherCode(String countyCode) {
		String address = "http://www.weather.com.cn/data/list3/city" + countyCode + ".xml";
		queryFromServer(address, "countyCode");
	}

	/* ��ѯ������������Ӧ������ */
	private void queryWeatherInfo(String weatherCode) {
		String address = "http://www.weather.com.cn/data/cityinfo/" + weatherCode + ".html";
		queryFromServer(address, "weatherCode");
	}

	/* ���ݴ���ĵ�ַ������ȥ���������ѯ���������������Ϣ */
	private void queryFromServer(String address, final String type) {
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {

			@Override
			public void onFinish(String response) {
				if ("countyCode".equals(type)) {
					if (!TextUtils.isEmpty(response)) {
						String[] array = response.split("\\|");
						if (array != null && array.length == 2) {
							String weatherCode = array[1];
							queryWeatherInfo(weatherCode);
						}
					}
				} else if ("weatherCode".equals(type)) {
					Utility.handleWeatherResponse(WeatherActivity.this, response);
					runOnUiThread(new Runnable() {
						public void run() {
							showWeather();
						}
					});
				}
			}

			@Override
			public void onError(Exception e) {
				runOnUiThread(new Runnable() {
					public void run() {
						publishText.setText("ͬ��ʧ��");
					}
				});
			}
		});
	}

	/* ��sharedPreferences�ļ��ж�ȡ�洢��������Ϣ������ʾ�������� */
	private void showWeather() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		cityNameText.setText(prefs.getString("city_name", "����ʧ��"));
		temp1Text.setText(prefs.getString("temp1", ""));
		temp2Text.setText(prefs.getString("temp2", ""));
		String weatherDesp = prefs.getString("weather_desp", "loding...");
		weatherDespText.setText(weatherDesp);
		publishText.setText("��" + prefs.getString("publish_time", "") + "����");
		currentDateText.setText(prefs.getString("current_date", ""));
		if (!TextUtils.isEmpty(weatherDesp)) {
			switch (weatherDesp) {
			case "��":
				weatherLayout.setBackgroundResource(R.drawable.sunny);
				break;
			case "��ת����":
				weatherLayout.setBackgroundResource(R.drawable.sunny_cloudy);
				break;
			case "����ת��":
				weatherLayout.setBackgroundResource(R.drawable.cloudy_sunny);
				break;
			case "����":
				weatherLayout.setBackgroundResource(R.drawable.cloudy);
				break;
			default:
				break;
			}
		}
		weatherInfoLayout.setVisibility(View.VISIBLE);
		cityNameText.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.switch_city:
			Intent intent = new Intent(WeatherActivity.this, ChooseAreaActivity.class);
			intent.putExtra("from_weather_activity", true);
			startActivity(intent);
			finish();
			break;
		case R.id.refresh_city:
			publishText.setText("ͬ����...");
			SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
			String weatherCode = spf.getString("weather_code", "");
			if (!TextUtils.isEmpty(weatherCode)) {
				queryWeatherInfo(weatherCode);
			}
			break;
		default:
			break;
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();

	}

}