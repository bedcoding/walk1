package com.example.ggavi.registeration.ahn1;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ggavi.registeration.phu1.NormalMode;
import com.example.ggavi.registeration.R;


public class FirstActivity extends AppCompatActivity {

    private Button normalModeButton;
    private Button loginButton;
    private ImageButton questionMarkButton;
    private TextView walkAwayTitle;
    Typeface font_one;
    private ImageButton infoButton;
  //  Typeface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getSupportActionBar().hide();

        font_one = Typeface.createFromAsset(getAssets(), "fonts/font_one.ttf"); //TitilliumWeb-Light from Titillium Web by Accademia di Belle Arti di Urbino (1001freefonts.com)
        normalModeButton = (Button) findViewById(R.id.normalModeButton);
        loginButton = (Button) findViewById(R.id.loginButton);
        infoButton = (ImageButton)findViewById(R.id.infoButton);
        questionMarkButton = (ImageButton) findViewById(R.id.questionMarkButton);
        walkAwayTitle = (TextView)findViewById(R.id.walkAwayTitle);
        walkAwayTitle.setTypeface(font_one);


        normalModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NormalMode.class);
                startActivityForResult(intent, 0);
                finish();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

        questionMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(FirstActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //for title bars not to be appeared (타이틀 바 안보이게)
                dialog.setContentView(R.layout.exp_dialog);

                dialog.setCanceledOnTouchOutside(false); //to prevent dialog getting dismissed on outside touch
                dialog.setCancelable(false); //to prevent dialog getting dismissed on back button
                dialog.show();

                Button dialogButton = (Button) dialog.findViewById(R.id.confirmButton);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,Pop.class);
                startActivity(intent);
            }
        });

    }

    // 두번 뒤로가기 버튼을 누르면 종료
    private long lastTimeBackPressed;
    @Override
    public void onBackPressed() {
        // 한번 버튼을 누른 뒤, 1.5초 이내에 또 누르면 종료
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500)
        {
            finish();
            return;
        }

        Toast.makeText(this, "뒤로가기 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

}

