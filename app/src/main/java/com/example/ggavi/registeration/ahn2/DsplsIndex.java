package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

public class DsplsIndex extends LifeIndex {

    private int value;
    private int color;
    private int grade;
    private String data[]={"▶ 전원 쾌적함을 느낌",
            "▶ 불쾌감을 나타내기 시작함\n" +
                    "▶ 어린이, 노약자 등 더위에 취약한 사람들은 야외활동을 시 가벼운 옷을 입기\n" +
                    "▶ 수분을 충분히 섭취함",
            "▶ 50% 정도 불쾌감을 느낌\n" +
                    "▶ 어린이, 노약자 등 더위에 취약한 사람들은 12시~5시 사이에는 야외활동을 \n" +
                    "   자제하거나 가벼운 옷을 입기\n" +
                    "▶ 에어컨, 제습기, 실내 환기 등을 통해 실내 온습도를 조절함\n" +
                    "▶ 지속적으로 수분을 섭취함",
            "▶ 전원 불쾌감을 느낌\n" +
                    "▶ 어린이, 노약자 등 더위에 취약한 사람들은 야외활동을 자제함\n" +
                    "▶ 에어컨, 제습기, 실내 환기 등을 통해 실내 온습도를 조절하거나 무더위쉼터 \n" +
                    "   등으로 이동하여 휴식\n" +
                    "▶ 수분을 미리 충분히 섭취"};
    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public int getGradeToInt() {
        return this.grade;
    }

    @Override
    public String getGradeToString(String data) {
        value = Integer.valueOf(data);
        if (value < 68) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "낮음";
        } else if (value >= 68 && value < 75) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "보통";
        } else if (value >= 75 && value < 80) {
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
