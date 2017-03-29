package com.example.inkweather.activity;

import com.example.inkweather.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class HomeActivity extends Activity implements OnClickListener {
	private ImageButton locationBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.setTheme(R.style.AppTheme_blank);
		super.onPostCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		init();
	}

	private void init() {
		locationBtn = (ImageButton) findViewById(R.id.location_btn);
		locationBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.location_btn:
			Intent intent = new Intent(HomeActivity.this, ChooseAreaActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}

	}
}
