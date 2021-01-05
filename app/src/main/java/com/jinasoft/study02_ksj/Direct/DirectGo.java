package com.jinasoft.study02_ksj.Direct;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.jinasoft.study02_ksj.R;

public class DirectGo extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;
    private ImageView DirectGOIV;
    private Button DirectBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_go);
        DirectGOIV = (ImageView)findViewById(R.id.DirectAct_IV);
        DirectBTN = (Button)findViewById(R.id.DirectAct_AddBTN);




        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this); // 프랩을 기본저장방식으로 받고
        String packageName = pref.getString("pref", null); //저장된 pref 값을 얻음, 만약 저장된 값이 없을 경우 기본값으로 null 반환

        if (packageName != null){
            // 패키지명이 있으면
            try {
                Drawable icon = getPackageManager().getApplicationIcon(packageName); // 아이콘을 이미지뷰에 표시
                DirectGOIV.setImageDrawable(icon);
            }catch (PackageManager.NameNotFoundException e){
                e.printStackTrace(); //리턴값이 없고 됨 에러가 나면 발생근원지를 찾아 단계별로  로그에 출력이
            }
        }

        DirectBTN.setOnClickListener(view -> {
            Intent intent = new Intent(this, AppListActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
            Log.d("확인" , "리쿼스트 코드" + REQUEST_CODE);
        }); // 앱을 시작 할 때 pref값을 가지고와서 바로가기를 복원하는 작업이 안되서 저장은 되나 값을 못갖구옴


        DirectGOIV.setOnClickListener(view -> {
            ImageView imageView = (ImageView) view; // 일회성 이미지 뷰 생성
            Drawable drawable = imageView.getDrawable(); // 일회성 보여지는 이미지 생성

            if (drawable != null){
                //프랩에 pref 키로 저장된 패키지명을 가져옴
                if (packageName != null) {
                    Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
                    //이 패키지를 실행할 수 있는 인텐트를 얻어서 액티비티 시작
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){ // 데이터가 비어있지않고 코드가 일치하면
                //AppListActivity.java로 부터 넘겨받은 앱 정보 객체
            //Pacelable 객체를 받기 위해 getParcelableExtra()로 얻음
            ApplicationInfo info = data.getParcelableExtra("info");
            //loadIcon()에 PackageManager를 넘겨주면 아이콘을 Drawable로 얻을 수 있음
            Drawable icon = info.loadIcon(getPackageManager());
            //기본 SharedPreferences 환경을 얻음
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            // 공유 환경설정 파일에 쓰려면 edit()을 호출하여 만들어야함
            SharedPreferences.Editor edit = preferences.edit();
            // info 객체로 packageName을 얻고, shortcut 키와 함께 프래퍼런스에 저장
            edit.putString("pref", info.packageName);
            // 변경사항 적용
            edit.apply();
            DirectGOIV.setImageDrawable(icon);
        }
    }
}