
package com.jinasoft.study02_ksj.Direct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jinasoft.study02_ksj.R;

import java.util.List;

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);

        ListView listView = (ListView)findViewById(R.id.ListAct_LV);

        //기기에 설치된 모든 앱 목록
        PackageManager PM = getPackageManager(); // 패키지매니저는 설치된 앱의 모든 정보를 얻을 수 있는 객체
        List<ApplicationInfo> infos = // infos 는 변수 / 배열 형태로 모든 앱의 정보를 얻을수 있는데 어플리케이션인포 객체에 담겨 있다.
                PM.getInstalledApplications(PackageManager.GET_META_DATA);
        ModelClass_AppInfo adapter = new ModelClass_AppInfo(infos); //앱 정보를 담고있는 어댑터 생성
        listView.setAdapter(adapter); // 리스트 뷰의 어댑터를 지정

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // 클릭한 리스트의 데이터 정보 반환
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ApplicationInfo info = (ApplicationInfo) (adapterView.getAdapter()).getItem(position);
                Intent intent = new Intent();
                intent .putExtra("info", info);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}