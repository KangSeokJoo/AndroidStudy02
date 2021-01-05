package com.jinasoft.study02_ksj.AdapterView;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinasoft.study02_ksj.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter extends BaseAdapter {

    private final List<ModelClass_Weather> DataList; // 빨간줄 나오는데 그대로 임포트 박으면됌
    //List를 구현한 모든 것 (ArrayList 등)을 받는 생성자

    private Map<String, Integer> WeatherImageMap;

    public Adapter(List<ModelClass_Weather> dataList) {
        DataList = dataList;
        WeatherImageMap = new HashMap<>();
        WeatherImageMap.put("맑음", R.drawable.sunny);
        WeatherImageMap.put("폭설", R.drawable.blizzard);
        WeatherImageMap.put("구름", R.drawable.cloudy);
        WeatherImageMap.put("비", R.drawable.rainy);
        WeatherImageMap.put("눈", R.drawable.snow);
    } // 해시맵 -> 키값을 받아오면 다른 데이터를 집어넣을수 있다.


    @Override
    public int getCount() {
        return DataList.size();
    } //아이템의 개수 반환하는만큼의 숫자

    @Override
    public Object getItem(int i) {
        return DataList.get(i);
    } //i번째의 아이템

    @Override
    public long getItemId(int i) {
        return i;
    } //i번째의 아이디 SQLite 데이터를 다룰땐 실제 데이터베이스에 저장된 ID를 반환하면 됀다

    @Override // 어댑터의 가장 핵심 , LayoutInflater는 액티비티 이외의 클래스에서 콘텍트를 통해 XML로 정의한 레이아웃을 로드해 view로 반환해주는 클래스
    // 이 레이아웃의 부모 뷰그룹인 viewgroup을 지정 , 루트레이아웃인지 아닌지 지정 , 이 뷰는 리스트 별 각 아이템이므로 false
    public View getView(int i, View view, ViewGroup viewGroup) {
        //리스트뷰의 성능 최적화 뷰홀더 패턴  어댑터의 getView() 매서드는 아이템이 화면에 표시 될 때마다 호출 쓸모없는 동작, 반복코드는 최대한 줄여야한다
        // if view == null 추가 -> id 찾는 동작들이 많아지면 성능에 영향을 줌, view는 재사용 되므로 null일때마 레이아웃인플레이톨을 로드하도록 수정
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder(); //뷰홀더 패턴 추가하면서 집어넣는것
            view = LayoutInflater.from(
                    viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup, false);
            //날씨, 도시, 기온 View
            // 뷰 홀더 패턴으로 findViewById 매서드를 빈번하게 호출하는것을 막는것 -> ViewHolder
            ImageView weatherImage = (ImageView)view.findViewById(R.id.Item_WeatherIV);
            TextView cityText = (TextView)view.findViewById(R.id.Item_CityTV);
            TextView tempText = (TextView)view.findViewById(R.id.Item_TempTV);

            holder.weatherImage = weatherImage;
            holder.cityText = cityText;
            holder.tempText = tempText;
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        // 현재 i의 날씨 데이터
        ModelClass_Weather weather = DataList.get(i);
        //데이터 설정
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        holder.weatherImage.setImageResource(WeatherImageMap.get(weather.getWeather())); // 해쉬맵을 한것을 이미지뷰를 셋팅한다.
        return view;
    } // i 번째의 아이템의 view를 구성하는 부분
    //ListView의 각 아이템에 해당하는 뷰는 실제 아이템의 개수만큼 생성 되는것이 아니라 화면에 보이는 만큼만 생성 온보이던것들은 새로보이는 아이템의 뷰로 재사용됨
    //겟뷰 두번째 파라미터로 넘어오는 view는 재사용 시에 이전에 생성되었던 반환했던 View 이다. 최초는 null값

    static class ViewHolder {
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }
}
