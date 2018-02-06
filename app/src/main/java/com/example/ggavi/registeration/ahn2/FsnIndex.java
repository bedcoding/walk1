package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

public class FsnIndex extends LifeIndex {
    private int value;
    private int color;
    private int grade;
    private String data[]= {"▶ 식중독 발생가능성은 낮으나 식중독 예방에 지속적인 관심이 요망됨\n" +
            "▶ 화장실 사용 후, 귀가 후, 조리 전에 손 씻기를 생활화",
            "▶ 식중독 발생가능성이 중간 단계이므로 식중독예방에 주의가 요망됨\n" +
                    "▶ 조리음식은 중심부까지 75℃(어패류 85℃)로 1분 이상 완전히 익히고 외부로 " +
                    "운반할 때에는 가급적 아이스박스 등을 이용하여 10℃이하에서 보관 및 운반",
            "▶ 식중독 발생가능성이 높으므로 식중독 예방에 경계가 요망됨 \n" +
                    "▶ 조리도구는 세척, 소독 등을 거쳐 세균오염을 방지하고 유통기한, 보관방법 등을" +
                    " 확인하여 음식물 조리. 보관에 각별히 주의하여야 함",
            "▶ 식중독 발생가능성이 매우 높으므로 식중독 예방에 각별한 경계가 요망됨 \n" +
                    "▶ 설사, 구토 등 식중독 의심 증상이 있으면 의료기관을 방문하여 의사 지시에 따름 \n" +
                    "▶ 식중독 의심 환자는 식품 조리 참여에 즉시 중단하여야 함",
            };


    @Override
    public void setValue(String value){
        super.setValue(value);
    }

    @Override
    public int getGradeToInt() {
        return this.grade;
    }

    @Override
    public String getGradeToString(String data) {
        value = Integer.valueOf(data);
        if (value < 55) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "관심";
        } else if (value >= 55 && value < 71) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "주의";
        } else if (value >= 71 && value < 86) {
            color= Color.rgb(253,141,60);
            grade=2;
            return "경고";
        } else
            color= Color.rgb(240,59,32);
            grade=3;
            return "위험";
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
