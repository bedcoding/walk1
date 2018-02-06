package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;


class AsthmaWhoIndex  extends LifeIndex {

    private int value;
    private int color;
    private int grade;

    private String data[] = {
            "▶ 평소 건강관리에 유의하기",
            "▶ 규칙적인 생활습관 유지하기\n" +
                    "▶ 만성 천식·폐질환 환자들은 주의",
            "▶ 실내를 청결하게 하고 자주 환기하기\n" +
                    "▶ 대기오염이 증가하는 시기에는 창문과 문을 닫아 외부 노출을 줄이고 공기청정기 사용하기",
            "▶ 청결한 환경을 유지하는데 각별히 신경 쓰기\n" +
                    "▶ 천식환자들은 각별한 주의 요망"};

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

