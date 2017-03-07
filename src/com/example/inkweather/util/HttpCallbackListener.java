package com.example.inkweather.util;

public interface HttpCallbackListener {
	void onFinish(String response);

	void onError(Exception e);
}
