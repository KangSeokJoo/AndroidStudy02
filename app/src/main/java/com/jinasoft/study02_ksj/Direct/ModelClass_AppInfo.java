package com.jinasoft.study02_ksj.Direct;


import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinasoft.study02_ksj.R;

import java.util.List;

public class ModelClass_AppInfo extends BaseAdapter { // BaseAdapter 를 익스텐드 해서 빨간줄에서 Alt enter를 하면 get시리즈 4개 자동 생성

    private List<ApplicationInfo> infos; //리스트 안에 담을 데이터들을 저장함.
    public ModelClass_AppInfo(List<ApplicationInfo> data){
        infos = data;
    }
    //어댑터를 개별화 하기 위해 BaseAdapter를 상속 받은것

    @Override
    public int getCount() {
        return infos.size();
    } //어플 갯수많큼 반환

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    } //어플 i 번째의 데이터

    @Override
    public long getItemId(int position) {
        return position;
    } // 어플 i번째의 ID 값

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
     // i는 담을 순서, View는 보여지는 레이아웃, ViewGroup 은 리스트뷰를 의미 화면을 셋팅하는 메소드

        ViewHolder holder; // 메소드 생성자 선언

        if (view == null){  //리스트 안에 비어있으면
            holder = new ViewHolder(); //생성 호출
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itme_app, viewGroup, false);
            // 레이아웃객체 생성
            holder.imageView = (ImageView)view.findViewById(R.id.Item_IconIV); // 이미지 깔고
            holder.textView = (TextView)view.findViewById(R.id.Item_NameTV); // 택스트 깔고
            view.setTag(holder); // 레이아웃에 태그를 입혀준다
        }else {
            holder = (ViewHolder)view.getTag(); // 안비어있으면 홀더에 있는 레이아웃 태그번호 갖구와서 보여주라
        }

        //앱정보
        ApplicationInfo info = infos.get(i);
        //앱 아이콘
        Drawable icon = info.loadIcon(viewGroup.getContext().getPackageManager());
        holder.imageView.setImageDrawable(icon);
        //앱 이름
        String name = String.valueOf(info.loadLabel(viewGroup.getContext().getPackageManager()));
        holder.textView.setText(name);
        return view;
    }
    private static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}