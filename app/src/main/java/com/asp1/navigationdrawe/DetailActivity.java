package com.asp1.navigationdrawe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.widget.TextView;

import com.asp1.navigationdrawe.ui.gallery.GalleryFragment;



public class DetailActivity extends AppCompatActivity {
    private int positionCountry;
    TextView cases,deaths,tcases,tdeaths,recoverd,todayrecovered,casespermillion,deathspermillion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        positionCountry=intent.getIntExtra("position",0);
        getSupportActionBar().setTitle("Updates of "+GalleryFragment.modelClassList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        cases=findViewById(R.id.dcases);
        deaths=findViewById(R.id.ddeaths);
        tcases=findViewById(R.id.dtcase);
        tdeaths=findViewById(R.id.dtdeaths);
        todayrecovered=findViewById(R.id.ctrecovered);

        recoverd=findViewById(R.id.crecovered);
        casespermillion=findViewById(R.id.casespermillion);
        deathspermillion=findViewById(R.id.deathspermillion);




        cases.setText(GalleryFragment.modelClassList.get(positionCountry).getCases());
        deaths.setText(GalleryFragment.modelClassList.get(positionCountry).getDeaths());
        tcases.setText(GalleryFragment.modelClassList.get(positionCountry).getTodaycases());
        tdeaths.setText(GalleryFragment.modelClassList.get(positionCountry).getTodaydeaths());
        recoverd.setText(GalleryFragment.modelClassList.get(positionCountry).getRecovered());
        todayrecovered.setText(GalleryFragment.modelClassList.get(positionCountry).getTodayRecovered());
        casespermillion.setText(GalleryFragment.modelClassList.get(positionCountry).getCasesPerOneMillion());
        deathspermillion.setText(GalleryFragment.modelClassList.get(positionCountry).getDeathsPerOneMillion());


    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}