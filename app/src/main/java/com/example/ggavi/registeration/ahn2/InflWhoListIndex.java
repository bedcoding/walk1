package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

class InflWhoListIndex  extends LifeIndex {

    private int value;
    private int color;
    private int grade;

    private String data[]={
            "▶ 감기예방을 위한 건강한 생활습관 유지\n",
            "▶ 규칙적인 생활습관 유지하기\n" +
                    "▶ 수분을 적절히 섭취하고, 외출 후 손과 발을 씻음",
            "▶ 충분한 수면을 취하고, 과로하지 말기\n" +
                    "▶ 체온을 유지하고 실내 적정한 온습도 유지하기",
            "▶ 가급적 외출을 자제하고 과로하지 말기\n" +
                    "▶ 외출 시 마스크, 목도리 등을 착용하여 몸을 따뜻하게 하고 체온 유지하기\n" +
                    "▶ 머리나 몸이 물에 젖어있을 경우 몸을 충분히 말린 후 외출하기"};

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
