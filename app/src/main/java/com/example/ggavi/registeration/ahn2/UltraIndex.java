package com.example.ggavi.registeration.ahn2;

import android.graphics.Color;

public class UltraIndex extends LifeIndex {
    private int value;
    private int color;
    public int grade;

    private String data[]={"▶ 햇볕 노출에 대한 보호조치가 필요하지 않음 \n▶ 그러나 햇볕에 민감한 피부를 가진 분은 자외선 차단제를 발라야 함",
    "▶ 2～3시간 내에도 햇볕에 노출 시에 피부 화상을 입을 수 있음 \n" +
            "▶ 모자, 선글라스 이용 \n" +
            "▶ 자외선 차단제를 발라야 함",
    "▶ 햇볕에 노출 시 1～2시간 내에도 피부 화상을 입을 수 있어 위험함\n" +
            "▶ 한낮에는 그늘에 머물러야 함\n" +
            "▶ 외출 시 긴 소매 옷, 모자, 선글라스 이용\n" +
            "▶ 자외선 차단제를 정기적으로 발라야 함",
    "▶ 햇볕에 노출 시 수십 분 이내에도 피부 화상을 입을 수 있어 매우 위험함 \n" +
            "▶ 오전 10시부터 오후 3시까지 외출을 피하고 실내나 그늘에 머물러야 함 \n" +
            "▶ 외출 시 긴 소매 옷, 모자, 선글라스 이용\n" +
            "▶ 자외선 차단제를 정기적으로 발라야 함",
    "▶ 햇볕에 노출 시 수십 분 이내에도 피부 화상을 입을 수 있어 가장 위험함\n" +
            "▶ 가능한 실내에 머물러야 함\n" +
            "▶ 외출 시 긴 소매 옷, 모자, 선글라스 이용\n" +
            "▶ 자외선 차단제를 정기적으로 발라야 함"};

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
        if (value < 3) {
            color= Color.rgb(229,229,229);
            grade=0;
            return "낮음";
        } else if (value >= 3 && value < 6) {
            color= Color.rgb(254,217,142);
            grade=1;
            return "보통";
        } else if (value >= 6 && value < 8) {
            color= Color.rgb(253,141,60);
            grade=2;
            return "높음";
        } else if (value >= 8 && value < 11) {
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
                return data[4];
        }
        return null;
    }
}
