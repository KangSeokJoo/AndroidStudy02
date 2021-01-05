package com.jinasoft.study02_ksj.Callback;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment { //내부에 리스트뷰와 텍스트뷰를 한 개 씩 포함하고 있는 프래그먼트

    private OnColorSelectedListener Listener;
    public void setOnColorSelectedListener(OnColorSelectedListener listener){
        Listener = listener;
    }

    interface OnColorSelectedListener {
        void onColorSelected(int Color);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            Listener = (OnColorSelectedListener) context;
        }catch (ClassCastException e){
        throw new ClassCastException(((Activity)context).getLocalClassName() + "는 OnColorSelectedListener를 구현해야 합니다.");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // onCreateView() onActivityCreated 사이에 호출되는 콜백 매서드
        super.onViewCreated(view, savedInstanceState); 
        List<String> colorlist = Arrays.asList("Red", "Green", "Blue");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorlist);
        setListAdapter(adapter); // 어댑터를 전달
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;

        switch (colorString){
            case "Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
        }
        if (Listener != null){
         Listener.onColorSelected(color);
        }
    }
}
