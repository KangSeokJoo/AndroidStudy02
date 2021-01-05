package com.jinasoft.study02_ksj.AdapterView;

public class ModelClass_Weather {
    //캡슐화 -> 외부에서 접근 불가 get, set 게터세터를 만들어서 접근해야함
    private String city; //도시명
    private String temp; //온도
    private String weather; // 날씨


     // 생성자 콘스트럭트 , 게터세터 , 투 스트링 (스트링버퍼) Alt + Insert로 삽입 / 모델클래스 기초
     public ModelClass_Weather(String city, String temp, String weather) {
         this.city = city;
         this.temp = temp;
         this.weather = weather;
     }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ModelClass_Weather{");
        sb.append("city='").append(city).append('\'');
        sb.append(", temp='").append(temp).append('\'');
        sb.append(", weather='").append(weather).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}

