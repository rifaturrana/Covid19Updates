package com.asp1.navigationdrawe.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.asp1.navigationdrawe.R;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;


import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private int position;
    TextView deaths;
    ListView listView;
    ModelDate modelDate;
    SimpleArcLoader loader;
    private RewardedVideoAd mRewardedVideoAd;
private InterstitialAd mInterstitialAd;
    private ArrayList<ModelDate> modelDateArrayList = new ArrayList<>();
    private ArrayList<ModelCountry> modelCountries = new ArrayList<>();
    DateAdapter dateAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        position = getIntent().getIntExtra("position", 0);

        deaths = findViewById(R.id.deaths);
        listView = findViewById(R.id.lv);
        loader = findViewById(R.id.loaderDetail);
        AdRequest adRequest=new AdRequest.Builder().build();
mInterstitialAd=new InterstitialAd(this);
mInterstitialAd.setAdUnitId("ca-app-pub-4875345024018177/8038023845");
mInterstitialAd.loadAd(adRequest);
mInterstitialAd.setAdListener(new AdListener(){
    @Override
    public void onAdLoaded() {
        if(mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
    }
});
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {
            switch (position) {
                case 0: {
                    String url = "https://api.covid19api.com/total/country/US";
                    fetchData(url);
                }
                case 1: {
                    String url = "https://api.covid19api.com/total/country/IND";


                    fetchData(url);
                }
                case 2: {
                    String url = "https://api.covid19api.com/total/country/brazil";
                    fetchData(url);
                }
                case 3: {
                    String url = "https://api.covid19api.com/total/country/russia";
                    fetchData(url);
                }
                case 4: {
                    String url = "https://api.covid19api.com/total/country/peru";
                    fetchData(url);
                }
                case 5: {
                    String url = "https://api.covid19api.com/total/country/colombia";
                    fetchData(url);
                }
                case 6: {
                    String url = "https://api.covid19api.com/total/country/mexico";
                    fetchData(url);
                }
                case 7: {
                    String url = "https://api.covid19api.com/total/country/south-africa";
                    fetchData(url);
                }
                case 8: {
                    String url = "https://api.covid19api.com/total/country/spain";
                    fetchData(url);
                }
                case 9: {
                    String url = "https://api.covid19api.com/total/country/argentina";
                    fetchData(url);
                }
                case 10: {
                    String url = "https://api.covid19api.com/total/country/france";
                    fetchData(url);
                }
                case 11: {
                    String url = "https://api.covid19api.com/total/country/chile";
                    fetchData(url);
                }
                case 12: {
                    String url = "https://api.covid19api.com/total/country/iran";
                    fetchData(url);
                }
                case 13: {
                    String url = "https://api.covid19api.com/total/country/united-kingdom";
                    fetchData(url);
                }
                case 14: {
                    String url = "https://api.covid19api.com/total/country/BGD";
                    mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getApplicationContext());
                    mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());
                    mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
                        @Override
                        public void onRewardedVideoAdLoaded() {
                            if(mRewardedVideoAd.isLoaded())
                            {
                                mRewardedVideoAd.show();
                            }
                        }

                        @Override
                        public void onRewardedVideoAdOpened() {

                        }

                        @Override
                        public void onRewardedVideoStarted() {

                        }

                        @Override
                        public void onRewardedVideoAdClosed() {

                        }

                        @Override
                        public void onRewarded(RewardItem rewardItem) {

                        }

                        @Override
                        public void onRewardedVideoAdLeftApplication() {

                        }

                        @Override
                        public void onRewardedVideoAdFailedToLoad(int i) {

                        }

                        @Override
                        public void onRewardedVideoCompleted() {

                        }
                    });

                    fetchData(url);
                }
                case 15: {
                    String url = "https://api.covid19api.com/total/country/saudi-arabia";
                    fetchData(url);
                }
                case 16: {
                    String url = "https://api.covid19api.com/total/country/iraq";
                    fetchData(url);
                }
                case 17: {
                    String url = "https://api.covid19api.com/total/country/pakistan";
                    fetchData(url);
                }
                case 18: {
                    String url = "https://api.covid19api.com/total/country/turkey";
                    fetchData(url);
                }
                case 19: {
                    String url = "https://api.covid19api.com/total/country/italy";
                    fetchData(url);
                }
                case 20: {
                    String url = "https://api.covid19api.com/total/country/philippines";
                    fetchData(url);
                }
                case 21: {
                    String url = "https://api.covid19api.com/total/country/germany";
                    mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getApplicationContext());
                    mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());
                    mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
                        @Override
                        public void onRewardedVideoAdLoaded() {
                            if(mRewardedVideoAd.isLoaded())
                            {
                                mRewardedVideoAd.show();
                            }
                        }

                        @Override
                        public void onRewardedVideoAdOpened() {

                        }

                        @Override
                        public void onRewardedVideoStarted() {

                        }

                        @Override
                        public void onRewardedVideoAdClosed() {

                        }

                        @Override
                        public void onRewarded(RewardItem rewardItem) {

                        }

                        @Override
                        public void onRewardedVideoAdLeftApplication() {

                        }

                        @Override
                        public void onRewardedVideoAdFailedToLoad(int i) {

                        }

                        @Override
                        public void onRewardedVideoCompleted() {

                        }
                    });
                    fetchData(url);
                }
                case 22: {
                    String url = "https://api.covid19api.com/total/country/indonesia";
                    fetchData(url);
                }
                case 23: {
                    String url = "https://api.covid19api.com/total/country/israel";
                    fetchData(url);
                }
                case 24: {
                    String url = "https://api.covid19api.com/total/country/ukraine";
                    fetchData(url);
                }
                case 25: {
                    String url = "https://api.covid19api.com/total/country/canada";
                    fetchData(url);
                }
                case 26: {
                    String url = "https://api.covid19api.com/total/country/bolivia";
                    fetchData(url);
                }
                case 27: {
                    String url = "https://api.covid19api.com/total/country/ecuador";
                    fetchData(url);
                }
                case 28: {
                    String url = "https://api.covid19api.com/total/country/qatar";
                    fetchData(url);
                }
                case 29: {
                    String url = "https://api.covid19api.com/total/country/romania";
                    fetchData(url);
                }
                case 30: {
                    String url = "https://api.covid19api.com/total/country/dominican-republic";
                    fetchData(url);
                }
                case 31: {
                    String url = "https://api.covid19api.com/total/country/kazakhstan";
                    fetchData(url);
                }
                case 32: {
                    String url = "https://api.covid19api.com/total/country/panama";
                    fetchData(url);
                }
                case 33: {
                    String url = "https://api.covid19api.com/total/country/belgium";
                    fetchData(url);
                }
                case 34: {
                    String url = "https://api.covid19api.com/total/country/morocco";
                    fetchData(url);
                }
                case 35: {
                    String url = "https://api.covid19api.com/total/country/egypt";
                    fetchData(url);
                }
                case 36: {
                    String url = "https://api.covid19api.com/total/country/kuwait";
                    fetchData(url);
                }


            }
        }
        else {
            Toast.makeText(SecondActivity.this,"Please Enable Internet Connection",Toast.LENGTH_LONG).show();
        }

        //getSupportActionBar().setTitle("Detail of"+SlideshowFragment.modelCountries.get(position).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }


    private void fetchData(String url) {
        loader.start();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = jsonArray.length() - 1; i >= 0; i--) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String confirmed = object.getString("Confirmed");
                        String deaths = object.getString("Deaths");
                        String recovered = object.getString("Recovered");
                        String active = object.getString("Active");
                        String date = object.getString("Date");
                        modelDate = new ModelDate(confirmed, deaths, recovered, active, date);
                        modelDateArrayList.add(modelDate);

                    }
                    dateAdapter = new DateAdapter(SecondActivity.this, modelDateArrayList);
                    listView.setAdapter(dateAdapter);
                    loader.stop();
                    loader.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                    loader.stop();
                    loader.setVisibility(View.GONE);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                loader.stop();
                loader.setVisibility(View.GONE);


            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(SecondActivity.this);
        requestQueue.add(request);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
