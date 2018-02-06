package com.example.ggavi.registeration.ahn2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ggavi.registeration.R;


public class ExpressionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("생활지수란");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(0);
        return inflater.inflate(R.layout.fragment_expression, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView textView = (TextView)getView().findViewById(R.id.textView15);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://health.seoul.go.kr/mosquito"));
                startActivity(intent);
            }
        });

    }



}
