package com.example.ggavi.registeration.ahn2;


import android.graphics.Color;

class SensorytmeLifeIndex extends LifeIndex {

    private int value;
    private int color;
    private int grade;

    private String data[]={
            "▶ 추위를 느끼는 정도가 증가함\n" +
                    "▶ 긴 옷이나 따뜻한 옷의 착용이 필요함",
            "▶ 노출된 피부에 매우 찬 기운이 느껴지고, 보호장구 없이 장기간 노출시저체온에\n" +
                    " 빠질 위험이 있으므로 방풍기능이 있는 겹옷이나 따뜻한 옷을 착용해야함\n" +
                    "▶ 모자, 벙어리장갑, 스카프의 착용이 필요함. 야외에서는 옷과 신발이 젖지 않도록 주의\n" +
                    "▶ 야외 근로자들은 작업 시 땀 흡수가 되는 방한복을 입도록 함",
            "▶ 10～15분이내 동상 위험이 있고, 보호장구 없이 장기간 노출시저체온에 빠질 \n" +
                    " 위험이 크므로 방풍기능이 있는 겹옷이나 따뜻한 겹옷을 착용해야함\n" +
                    "▶ 노출된 모든 피부를 덮고 모자, 벙어리장갑, 스카프, 목도리, 마스크의 착용이 \n" +
                    " 필요함\n" +
                    "▶ 피부가 바람에 직접 노출되지 않도록 할 것. 야외에서는 옷과 신발이 젖지 않도록 \n" +
                    " 주의\n" +
                    "▶ 야외 근로자들은 작업 시 땀 흡수가 되는 방한복을 입고 개인 난방기구를 \n" +
                    " 지참하도록 함",
            "▶ 노출된 피부는 몇 분 내에 얼게 되고, 야외 활동 시 저체온 위험이 매우 크므로 \n" +
                    " 방풍·보온기능이 있는 매우 따뜻한 겹옷을 착용해야 함\n" +
                    "▶ 노출된 모든 피부를 덮고 모자, 벙어리장갑, 스카프, 목도리, 마스크의 착용이 필요함\n" +
                    "▶ 야외환경은 생명에 매우 위험하므로 야외활동은 가급적 짧게 하거나 취소하여 실내에 머무를 수 있도록 할 것\n" +
                    "▶ 부득이하게 야외에서 작업을 해야 할 경우, 옷과 신발이 젖지 않도록 주의하고," +
                    " 작업 시 땀 흡수가 되는 방한복을 입고 개인 난방기구를 지참하도록 함"};

    @Override
    public void setValue(String value) {
        this.value = Integer.valueOf(value);
    }


    @Override
    public String getGradeToString(String data) {

        value = Integer.valueOf(data);
        if (value >= -10) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "관심";
        } else if (value < -10 && value >= -25) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "주의";
        } else if (value < -25 && value >= -45) {
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
                return data[1];
            case 3:
                return data[2];
        }
        return null;
    }
}
