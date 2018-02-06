package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

class BrainWhoIndex extends LifeIndex {

    private int value;
    private int color;
    private int grade;

    private String data[] = {
            "▶ 평소 뇌졸중 예방을 위한 건강관리에 유의하여 음식 섭취를 조절하고 가벼운 운동을 함",
            "▶ 평소 건강관리에 유의하고 규칙적인 운동과 함께 식습관 조절하기 \n" +
                    "▶ 뇌졸중 환자들은 외출 시 갑작스럽게 체온이 변하지 않도록 보온에 유념함",
            "▶ 혈압측정을 꾸준히 하면서 정상 혈압이 유지되도록 함 \n" +
                    "▶ 건강에 더욱 관심을 가지고 추운 곳으로 외출할 경우 보온 유지하기 \n" +
                    "▶ 특히 온도가 낮은 새벽이나 밤 시간을 피해 외출함",
            "▶ 꾸준한 혈압, 혈당, 콜레스테롤 수치를 측정하고 정상 수준으로 유지하도록 함 \n" +
                    "▶ 급격한 날씨 변화에 노출되지 않도록 외출 및 환기에 주의하기 \n" +
                    "▶ 고혈압 뇌졸중 기왕력 환자들은 각별한 주의 요망"};

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

