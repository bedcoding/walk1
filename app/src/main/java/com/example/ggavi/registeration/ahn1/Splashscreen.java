package com.example.ggavi.registeration.ahn1;


// (24) 시작 화면을 만들기 위해 넣음 (실행시 나오는 로고 영상)
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ggavi.registeration.R;
import com.example.ggavi.registeration.phu1.SavedSharedPreference;


import static com.example.ggavi.registeration.phu1.LoggedInWalk.MY_PERMISSIONS_REQUEST_LOCATION;


public class Splashscreen extends Activity {
    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        StartAnimations();
    }

    private void StartAnimations()
    {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l =(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 1500)
                    {
                        sleep(100);
                        waited += 100;
                    }
                    if(SavedSharedPreference.getId(Splashscreen.this).length() == 0)
                    {
                        Intent intent = new Intent(Splashscreen.this,
                                FirstActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        Splashscreen.this.finish();
                    }
                    else
                    {
                        Intent intent = new Intent(Splashscreen.this,
                                MainActivity.class);
                        intent.putExtra("userID",SavedSharedPreference.getId(Splashscreen.this));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        Splashscreen.this.finish();
                    }


                }

                catch (InterruptedException e)
                {
                    // do nothing
                }

                finally
                {
                    Splashscreen.this.finish();
                }
            }
        };
        splashTread.start();
    }

}