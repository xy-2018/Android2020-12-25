package com.coolweather.android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.coolweather.android.util.HttpUtil;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class XingzuoActivity extends AppCompatActivity {

    private TextView sport_text;
    private Spinner xingzuoTv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xingzuo);
        xingzuoTv = findViewById(R.id.xingzuoSp);
        sport_text = findViewById(R.id.sport_text);

        xingzuoTv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cardNumber = XingzuoActivity.this.getResources().getStringArray(R.array.languages)[position];
                getAll(cardNumber);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private Handler handler = new Handler();

    private void getAll(String cardNumber) {
        String weatherUrl = "http://web.juhe.cn:8080/constellation/getAll?consName=" + cardNumber + "&type=today&key=342a3467728b4f4242e6759b52bfe848"; // 这里的key设置为第一个实训中获取到的API Key
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            JSONObject object = new JSONObject(response.body().string());
                            if (object.getInt("error_code") == 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("\n星座名称：" + object.getString("name"));
                                sb.append("\n综合指数：" + object.getString("all"));
                                sb.append("\n幸运色：" + object.getString("color"));
                                sb.append("\n健康指数：" + object.getString("health"));
                                sb.append("\n爱情指数：" + object.getString("love"));
                                sb.append("\n财运指数：" + object.getString("money"));
                                sb.append("\n幸运数字：" + object.getString("number"));
                                sb.append("\n速配星座：" + object.getString("QFriend"));
                                sb.append("\n今日概述：" + object.getString("summary"));
                                sb.append("\n工作指数：" + object.getString("work"));
                                sport_text.setText(sb.toString());
                            } else {
                                sport_text.setText("暂无数据");
                            }
                        }catch (Exception e){

                        }

                    }
                });



            }
        });
    }


}