package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

class SkinWhoIndex extends LifeIndex {

    private int value;
    private int color;
    private int grade;

    private String data[]={
            "▶ 피부질환 환자들은 지속적인 관심 요망",
            "▶ 피부질환 환자들은 주의 요망",
            "▶ 실내온도와 습도를 일정하게 유지하고 충분한 수분 섭취하기",
                    "▶ 실외활동은 가급적 자제하고 쾌적한 환경 유지하기 \n" +
                            "▶ 피부질환 환자들은 각별한 주의 요망"};

    @Override
    public void setValue(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public int getGradeToInt() {
        return this.grade;
    }


    @Override
    public String getGradeToString(String data) {
        value = Integer.valueOf(data);
        if (value == 0) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "낮음";
        } else if (value == 1) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "보통";
        } else if (value == 2) {
            color= Color.rgb(253,141,60);
            grade=2;
            return "높음";
        } else
            color= Color.rgb(240,59,32);
        grade=3;
        return "매우높음";
    }
    public int getColor(){
        return color;
    }

    public String getData(){
        switch (grade){
            case 0:
                return data[0];
            case 1:
                return data[1];
            case 2:
                return data[2];
            case 3:
                return data[3];
        }
        return null;
    }
}
