package com.jinasoft.study02_ksj.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jinasoft.study02_ksj.R;

import java.util.Random;

public class FragMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmain);

        // 프래그먼트 조작을 위해 프래그먼트 매니저를 얻음
        FragmentManager fragmentManager = getSupportFragmentManager();
        //ColorFragment 를 findFragmentById()로얻음
        ColorFragment colorFragment = (ColorFragment) fragmentManager.findFragmentById(R.id.FragAct_Frag);

        //프래그먼트의 색상변경
        colorFragment.setColor(Color.BLUE);
    }

    public void change(View view) {
        ColorFragment fragment = new ColorFragment();
        // 0~ 255 RGB 랜덤 정수 뿌리기
        int red = new Random().nextInt(256);
        int green = new Random().nextInt(256);
        int blue = new Random().nextInt(256);
        //랜덤한 생각 설정
        fragment.setColor(Color.rgb(red,green,blue));
        getSupportFragmentManager().beginTransaction() //겟서포트프래그맨트매니저를  통해서 replace() 매서드로 프레그 영역에 이 프래그맨트로 교체하라는 명령
                .replace(R.id.FragAct_Frag)            // 교체 대신 삭제를 원하면 remove() 메서드
                .commit();                             // 추가를 원하면 ~~.beginTransaction().add(R.~~~).commit();
    }
}