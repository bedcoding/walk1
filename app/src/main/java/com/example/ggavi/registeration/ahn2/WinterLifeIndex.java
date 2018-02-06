package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

class WinterLifeIndex extends LifeIndex {

    private int value;
    private int color;
    private int grade;

    private String data[]={
            "▶동파가능성 낮음\n",
            "▶ 햇볕에 노출 시 1～2시간 내에도 피부 화상을 입을 수 있어 위험함\n" +
                    "▶ 수도계량기 보호함의 내부에는 헌옷을 채우고, 외부에는 테이프로 밀폐시켜" +
                    "찬 공기가 스며들지 않도록 보호해야 함\n" +
                    "▶ 복도식 아파트는 수도계량기 동파가 많이 발생하므로 수도계량기 보온에 유의하여야 함\n" +
                    "▶ 장기간 집을 비우게 될 때는 수도꼭지를 조금 틀어 수도관에 물이 흐르도록 해야 함\n" +
                    "▶ 마당에 노출된 수도관은 보온재로 감싸주고, 앞 고동의 수도꼭지는 항상 열어 놓고 뒷고동만 열고 잠궈야 함\n" +
                    "▶ 화장실 등 수도관이 노출되어 있는 경우에는 보온재로 감싸서 보온을 잘 하여야 함\n" +
                    "▶ 집안의 수도관이 얼었을 때는 헤어드라이어로 서서히 가열하여 녹이거나, 미지근한 물로 시작하여 점차 뜨거운 물로 녹이면 됨",
            "▶ 아래 설명 및 주의사항을 시행함과 함께 영하 10℃이하 혹한이 계속될 때에는 수도꼭지를 조금 틀어 수도관에 물이 흐르도록 해야 함\n" +
                    "▶ 수도계량기 및 수도관 동파 발생 시 지역 상하수도사업소에 연락하여 조치"};

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
        if (value == 25) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "낮음";
        } else if (value == 50) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "보통";
        } else if (value == 75) {
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
                return data[1];
            case 3:
                return data[2];
        }
        return null;
    }
}
