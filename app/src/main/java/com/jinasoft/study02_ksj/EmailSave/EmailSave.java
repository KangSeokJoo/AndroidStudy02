package com.jinasoft.study02_ksj.EmailSave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.jinasoft.study02_ksj.R;
import com.jinasoft.study02_ksj.SelectStudyList;

public class EmailSave extends AppCompatActivity {

    private EditText EmailEDT;
    private CheckBox SaveCB;

    private SharedPreferences pref; //데이터를 앱 폴더 내 파일로 저장 하는 객체 data/data/패키지네임/shared_prefs/SharedPreference

    @Override
    protected void onPause() { // 액티비티를 나가면 호출 되는 콜백 메소드
        super.onPause();
        Log.d("1","확인");
        SharedPreferences.Editor editor = pref.edit(); // 공유 환경설정 파일에 쓰려면 edit()을 호출하여 만들어야함
        editor.putBoolean("save", SaveCB.isChecked()); // 이메일저장 버튼을 눌르고 키값이 save인
        editor.putString("email", EmailEDT.getText().toString());// 입력한 이메일을 갖구온다
        editor.apply(); // 저장
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_save);

        EmailEDT = findViewById(R.id.EmailAct_EmailEDT);
        SaveCB = (CheckBox) findViewById(R.id.EmailAct_SaveCB);

        //프래퍼랜스 객체 초기화
        pref = PreferenceManager.getDefaultSharedPreferences(this);


        Boolean isChecked = pref.getBoolean("save",false);  //프랩에 (키값 , 불 타입)키에 해당하는 불리언 값 검색
        SaveCB.setChecked(isChecked); // cheack 박스가 체크 되면 위 와같이 행동
        Button btn = (Button)findViewById(R.id.EmailAct_LoginBTN);
        btn.setOnClickListener(view -> {
            Intent in = new Intent(this, SelectStudyList.class);
            startActivity(in);
        });

        if(isChecked){ // 체크 되면 이메일이라는 키에 입력한 에디트텍스트를 갖구온다.
            String email = pref.getString("email", "");
            EmailEDT.setText(email);
        }


    }
}