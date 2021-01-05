package com.jinasoft.study02_ksj.Callback;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jinasoft.study02_ksj.R;

public class CallbackMain extends AppCompatActivity implements ColorListFragment.OnColorSelectedListener{

    private ColorFragment colorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback_main);


        colorFragment = (ColorFragment)getSupportFragmentManager().findFragmentById(R.id.CallAct_FragColor);
//        colorFragment.setColor(Color.RED); 밑에 컬러 변수값으로 추가
    }
    @Override
    public void onColorSelected(int color){
        colorFragment.setColor(color);
    }
}