package com.example.ggavi.registeration.ahn2;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ggavi.registeration.R;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MosquitoFragment extends Fragment {
    private boolean INTERNET_STATE = true;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView12;
    TextView textView13;
    private String value;   //모기지수
    ImageView imageView;
    ScrollView scrollView;
    String key1;
    int textColor = 0;
    String date;
    String grade;
    public static mosquitoEntry mosquitoEntry;

    public void shareKakao()
    {
        try{
            final KakaoLink kakaoLink = KakaoLink.getKakaoLink(getActivity());
            final KakaoTalkLinkMessageBuilder kakaoBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
            kakaoBuilder.addText("오늘의 모기지수는 "+grade+" "+value+"입니다.");
            kakaoBuilder.addAppButton("앱 실행 혹은 다운로드");
            kakaoLink.sendMessage(kakaoBuilder, getContext());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.mosquito_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            thread();
            return (true);
        }
        if (item.getItemId() == R.id.share) {
            shareKakao();
            return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("모기예보");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setElevation(0);
        return inflater.inflate(R.layout.open1_fragment_mosquito, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);
        textView2 = (TextView) getView().findViewById(R.id.textView2);
        textView3 = (TextView) getView().findViewById(R.id.textView3);
        textView4 = (TextView) getView().findViewById(R.id.textView4);
        textView12 = (TextView) getView().findViewById(R.id.textView12);
        textView13 = (TextView) getView().findViewById(R.id.textView13);
        imageView = (ImageView) getView().findViewById(R.id.indicator);
        scrollView = (ScrollView) getView().findViewById(R.id.backGround);
        key1 = getResources().getString(R.string.key1);

        if(checkInternet()==false){
            INTERNET_STATE=false;
            getPreferences();
        }

        thread();
    }

    public void thread(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if(INTERNET_STATE==true) {
                    value = getXmlData(getDateString()); //모기지수
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        date=getDateStringToShow();
                        textView2.setText(date);
                        textView3.setText(value);  //TextView에 문자열  value 출력
                        textView4.setText(getGrade(value));

                        mosquitoEntry = LifeJisu_MainActivity.dbHelper.fetchEntryByIndex(getGradeDetail(Double.valueOf(value)));
                        grade= mosquitoEntry.getmGrade();

                        textView12.setText(mosquitoEntry.getDefence_activity());
                        textView13.setText(mosquitoEntry.getAggressive_activity());

                        setColor();
                        TranslateAnimation anim = new TranslateAnimation
                                (Animation.RELATIVE_TO_SELF,0,   // fromXDelta
                                        Animation.RELATIVE_TO_SELF, Float.valueOf(value)/(float)37.2,  // toXDelta
                                        Animation.RELATIVE_TO_SELF, 0,    // fromYDelta
                                        Animation.RELATIVE_TO_SELF, 0);// toYDelta
                        anim.setDuration(1000);
                        anim.setFillAfter(true);
                        imageView.startAnimation(anim);
                    }
                });
            }
        });
        t.start();
    }
    private long getGradeDetail(double value) {
        //1단계
        if(0<=value&&value<=500) {
            if (0 <= value && value <= 83.3) {
                return 1;
            } else if (83.4 <= value && value <= 166.6) {
                return 2;
            } else if (166.7 <= value && value <= 250) {
                return 3;
            }

            //2단계
            else if (250.1 <= value && value <= 333.3) {
                return 4;
            } else if (333.4 <= value && value <= 416.6) {
                return 5;
            } else if (416.7 <= value && value <= 500) {
                return 6;
            }
        }
        else if(500.1<=value&&value<=1000) {
            //3단계
            if (500.1 <= value && value <= 583.3) {
                return 7;
            } else if (583.4 <= value && value <= 666.6) {
                return 8;
            } else if (666.7 <= value && value <= 750) {
                return 9;
            }

            //4단계
            else if (750.1 <= value && value <= 833.3) {
                return 10;
            } else if (833.4 <= value && value <= 916.6) {
                return 11;
            } else if (916.7 <= value && value <= 1000) {
                return 12;
            }
        }
        return 0;

    }

    public boolean checkInternet() {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
            }
            return true;
        } else {
            return false;
        }
    }


     //값 불러오기
     private void getPreferences(){
         SharedPreferences pref = getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
         value=pref.getString("value", "");
         date=pref.getString("dateView", "");
         textView2.setText(date);
         textView3.setText(value);
         textView4.setText(getGrade(value));
     }

     // 값 저장하기
     private void savePreferences(){
         SharedPreferences pref = getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = pref.edit();
         editor.putString("value", value);
         editor.putString("dateView", date);
         editor.putInt("color", textColor);
         editor.putString("grade", grade);
         editor.commit();
     }


    private void setColor() {
        textView3.setBackgroundResource(R.drawable.rounded_corner);
        GradientDrawable drawable1 = (GradientDrawable) textView3.getBackground();
        textView4.setBackgroundResource(R.drawable.rounded_corner);
        GradientDrawable drawable2 = (GradientDrawable) textView4.getBackground();
        drawable1.setColor(textColor);
        drawable2.setColor(textColor);
    }

    public String getGrade(String data) {
        double value = Double.valueOf(data);
        if(value<=250){
            textColor = Color.rgb(255,205,189);
            return "1단계(쾌적)";
        }
        else if(250.1<=value&&value<=500){
            textColor = Color.rgb(255,153,51);
            return "2단계(관심)";
        }
        else if(500.1<=value&&value<=750){
            textColor = Color.rgb(255,178,102);
            return "3단계(주의)";
        }
        else if(750.1<=value&&value<=1000){
            textColor = Color.RED;
            return "4단계(불쾌)";
        }
        else
            return data;
    }

    public String getXmlData(String date) {
        StringBuffer buffer = new StringBuffer();

        String queryUrl = "http://openapi.seoul.go.kr:8088/"
                + key1    //요청 URL
                + "/xml"
                + "/MosquitoStatus"
                + "/1/5"
                + "/"+date;

        try {
            URL url = new URL(queryUrl); //문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is = url.openStream();  //url위치로 입력스트림 연결
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));  //inputstream 으로부터 xml 입력받기
            String tag;
            xpp.next();
            int eventType = xpp.getEventType();
            label1:
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();    //태그 이름 얻어오기
                        if (tag.equals("MOSQUITO_VALUE")) {
                            xpp.next();
                            buffer.append(xpp.getText()); //grade 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");          //줄바꿈 문자 추가
                        }
                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName();    //태그 이름 얻어오기
                        if (tag.equals("MOSQUITO_VALUE")) {
                            buffer.append("\n"); // 첫번째 검색결과종료..줄바꿈
                            break label1;
                        }
                        break;
                }
                eventType = xpp.next();

            }
            if(buffer.toString().trim().equals("")){
                throw new Exception("");
            }
        } catch (Exception e) {
            return getXmlData(getYesterday());
        }
        return buffer.toString().trim();
    }


    public String getDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA); // HH:mm:ss
        return df.format(new Date());
    }

    public String getDateStringToShow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd("+getDay()+")", Locale.KOREA);
        return df.format(new Date());
    }

    public String getDay(){
        String day = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int dayNum = cal.get(Calendar.DAY_OF_WEEK);
        switch (dayNum) {
            case 1:
                day = "일";
                break;
            case 2:
                day = "월";
                break;
            case 3:
                day = "화";
                break;
            case 4:
                day = "수";
                break;
            case 5:
                day = "목";
                break;
            case 6:
                day = "금";
                break;
            case 7:
                day = "토";
                break;
        }
        return day;
    }
    public String getYesterday() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        return df.format(yesterday());
    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public void onDestroy() {
        super.onDestroy();
        savePreferences();
    }



}