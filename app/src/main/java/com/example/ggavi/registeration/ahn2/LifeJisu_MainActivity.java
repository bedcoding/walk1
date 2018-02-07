package com.example.ggavi.registeration.ahn2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ggavi.registeration.R;
import com.tsengvn.typekit.TypekitContextWrapper;

public class LifeJisu_MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open1_weather_main);


        dbHelper = DbHelper.getsInstance(this);
        if(savedInstanceState == null){
            dbHelper = DbHelper.getsInstance(this);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toolbar.getNavigationIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        getSupportActionBar().setTitle("");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();   //최초화면

        WeatherFragment weatherFragment = new WeatherFragment();

        transaction.replace(R.id.content_frame, weatherFragment);
        transaction.commit();

        dbHelper.getWritableDatabase();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


/*

    //adding the menu on tool bar (액션바에서 메뉴 추가)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.weather_new_menu, menu);
        return true;
    }

    // adding actions that will be done on clicking menu items
    // (메뉴 아이템들을 클릭할 때 발생할 이벤트 추가)

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            // 버튼: 날씨/대기정보
            case R.id.home:
                home();
                return true;

            default:
                return true;
        }
    }

    // 버튼 (메인으로 이동)
    public void home() {
        Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
        startActivity(intent);
        finish();
    }
*/


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MosquitoFragment mosquitoFragment = new MosquitoFragment();
        WeatherFragment weatherFragment = new WeatherFragment();
        ExpressionFragment expressionFragment = new ExpressionFragment();
        AirFragment airFragment = new AirFragment();
        int id = item.getItemId();
        if (id == R.id.nav_weather) {
            transaction.replace(R.id.content_frame, weatherFragment);
        }
        else if (id == R.id.nav_mosquito) {
            transaction.replace(R.id.content_frame, mosquitoFragment);
        }

        else if (id == R.id.nav_expression) {
            transaction.replace(R.id.content_frame, expressionFragment);
        }

        else if (id == R.id.nav_air) {
            transaction.replace(R.id.content_frame, airFragment);
        }
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

}
