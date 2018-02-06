package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

public class HeatLifeIndex extends LifeIndex {

    private int value;
    private int color;
    private int grade;
    private String data[]= {"▶ 일반적으로 위험은 낮으나 수분섭취 등 건강관리에 유의",
            "▶ 열사병, 열경련 가능성이 있으므로 야외 활동 및 작업에 주의하고, 적극적 \n" +
                    "수분 섭취 필요\n" +
                    "▶ 땀을 많이 흘렸을 경우 염분과 미네랄 보충하기\n" +
                    "▶ 면소재의 헐렁하고 가벼운 옷 입기\n" +
                    "▶ 창문과 문이 닫힌 상태에서 선풍기를 틀지 않도록 주의",
            "▶ 열사병, 열경련 가능성이 높아지므로 낮 12시～오후 5시 사이에는 \n" +
                    "야외 활동 및 작업을 자제하고 햇볕을 차단\n" +
                    "▶ 주·정차된 차에 어린이나 동물을 혼자 두지 않도록 주의",
            "▶ 가급적 야외 활동 및 작업을 중지하고, 부득이한 경우 야외활동 시 자신의 \n" +
                    " 건강 상태를 살피며 활동의 강도를 조절하고 두통, 어지러움, 근육경련, \n" +
                    " 의식저하 등의 증상이 있으면 그늘이나 서늘한 실내에서 휴식을 취함\n" +
                    "▶ 특히, 노인이나 어린이 같은 취약계층의 경우 가급적 실내에서 활동하며 \n" +
                    " 냉방기기를 적절히 사용하여 실내 온도를 적정수준(26～28℃)을 유지하여 \n" +
                    " 각별한 주의 요망. 냉방기기가 없는 경우 냉방기기가 구비되어있는 \n" +
                    " 가까운 공공기관을 이용\n" +
                    "▶ 환자 발생 시 시원한 곳으로 이동시킨 후 119에 구급 요청",
    };

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
        if (value < 32) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "낮음";
        } else if (value >= 32 && value < 41) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "보통";
        } else if (value >= 41 && value < 54) {
            color= Color.rgb(253,141,60);
            grade=2;
            return "높음";
        } else if (value >= 54 && value < 66) {
            color= Color.rgb(240,59,32);
            grade=3;
            return "매우높음";
        } else
            color= Color.rgb(84,39,143);
            grade=4;
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
            case 4:
                return data[3];
        }
        return null;
    }
}
