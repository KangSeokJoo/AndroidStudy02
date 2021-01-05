package com.jinasoft.study02_ksj.DisplayRotation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jinasoft.study02_ksj.R;

public class DisplayRoatation extends AppCompatActivity {

    int Level = 0;
    int Score = 0;

    static final String STATE_SCORE = "playScore";
    static final String STATE_LEVEL = "playLevel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_roatation);

        TextView DisplayLVTV = (TextView)findViewById(R.id.DisplayAct_TV);
        TextView DisplaySCORETV = (TextView)findViewById(R.id.DisplayAct_SCORETV);
        Button LvUpBTN = (Button)findViewById(R.id.DisplayAct_LVUpBTN);
        Button ScoreUpBTN = (Button)findViewById(R.id.DisplayAct_SCOREUpBTN);

        DisplayLVTV.setText("레벨 :" + Level);
        DisplaySCORETV.setText("점수 :" + Score);

        if (savedInstanceState == null){
            //초기화할 코드
        }else {
            //상태복원
            Level = savedInstanceState.getInt(STATE_LEVEL);
            Score = savedInstanceState.getInt(STATE_SCORE);
            DisplayLVTV.setText("레벨 :" + Level);
            DisplaySCORETV.setText("점수 :" + Score);
        }

        LvUpBTN.setOnClickListener(view -> {
            Level++;
        });
        ScoreUpBTN.setOnClickListener(view -> {
            Score += 100;
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { //자동완성
        //상태저장
        outState.putInt(STATE_SCORE, Score);
        outState.putInt(STATE_LEVEL, Level);
        //항상 슈퍼클래스의 메소드를 호출
        super.onSaveInstanceState(outState);
    }
}