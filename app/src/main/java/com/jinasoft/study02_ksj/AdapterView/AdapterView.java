package com.jinasoft.study02_ksj.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jinasoft.study02_ksj.R;

import java.util.ArrayList;

public class AdapterView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);

        //리스트에 넣어질 자료
        ArrayList<ModelClass_Weather> datalist = new ArrayList<>();
        datalist.add(new ModelClass_Weather("수원", "25도","맑음"));
        datalist.add(new ModelClass_Weather("서울", "26도","비"));
        datalist.add(new ModelClass_Weather("안양", "24도","구름"));
        datalist.add(new ModelClass_Weather("화성", "23도","구름"));
        datalist.add(new ModelClass_Weather("부산", "28도","맑음"));
        datalist.add(new ModelClass_Weather("인천", "20도","비"));
        datalist.add(new ModelClass_Weather("대구", "21도","비"));
//        for (int i = 0; i < 30; i++){
//            datalist.add("data : " + i); // 어레이 리스트에 집어넣는 add 문
//        }
        Adapter adapter = new Adapter(datalist);
//        어댑터에 위에 설정한 ArrayList(ArrayAdapater라서 동일한 배열 필요)자료 자기 자신을 가리켜서 삽입
//        ArrayAdapter<String> adapter = new ArrayAdapter<>
//                (this, android.R.layout.simple_list_item_1, datalist); // simple list는 안드로이드 기본 제공 레이아웃 TextView 하나만 갖는 레이아웃 id

        //뷰와 어댑터 연결
        ListView listView = (ListView)findViewById(R.id.AdapterAct_LV);
        listView.setAdapter(adapter);

        //아이템 클릭 이벤트
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(AdapterView.this, position + " 번째 아이템 선택",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}