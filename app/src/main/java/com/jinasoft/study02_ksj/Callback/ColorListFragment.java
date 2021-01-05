package com.jinasoft.study02_ksj.Callback;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ColorListFragment extends ListFragment { //내부에 리스트뷰와 텍스트뷰를 한 개 씩 포함하고 있는 프래그먼트
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // onCreateView() onActivityCreated 사이에 호출되는 콜백 매서드
        super.onViewCreated(view, savedInstanceState); 
        List<String> colorlist = Arrays.asList("Red", "Green", "Blue"); //세가지 항목을 표시하도록 ArrayAdapter를 만든다 
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorlist);
        setListAdapter(adapter); // 어댑터를 전달
    }
}
