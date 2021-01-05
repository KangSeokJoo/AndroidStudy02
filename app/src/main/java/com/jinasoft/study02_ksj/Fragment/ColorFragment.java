package com.jinasoft.study02_ksj.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinasoft.study02_ksj.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorFragment extends Fragment {

    private TextView FragTV;
    private int fragcolor = Color.BLUE;

    public ColorFragment() { //오버로드 금지
        // Required empty public constructor
    }

    @Override //프래그먼트의 시작점
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_color, container, false);
        FragTV = (TextView)view.findViewById(R.id.FragAct_TV);
        return view;
    }

    public void setColor(int color){
        //텍스트뷰의 배경색을 변경
        fragcolor = color;
        if (FragTV != null){
            FragTV.setBackgroundColor(color);
        }
    }
}