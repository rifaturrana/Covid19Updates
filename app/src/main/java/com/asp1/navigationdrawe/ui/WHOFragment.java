package com.asp1.navigationdrawe.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asp1.navigationdrawe.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class WHOFragment extends Fragment {

TextView tv;

    private RewardedVideoAd mRewardedVideoAd;
    public WHOFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v=LayoutInflater.from(getContext()).inflate(R.layout.fragment_w_h_o,container,false);
       tv=v.findViewById(R.id.about);
        // Initialize the Google Mobile Ads SDK



       tv.setText("Coronavirus disease (COVID-19) is an infectious disease caused by a newly discovered coronavirus.\n" +
               "\n" +
               "Most people infected with the COVID-19 virus will experience mild to moderate respiratory illness and recover without requiring special treatment.  Older people, and those with underlying medical problems like cardiovascular disease, diabetes, chronic respiratory disease, and cancer are more likely to develop serious illness.\n" +
               "\n" +
               "The best way to prevent and slow down transmission is to be well informed about the COVID-19 virus, the disease it causes and how it spreads. Protect yourself and others from infection by washing your hands or using an alcohol based rub frequently and not touching your face. \n" +
               "\n" +
               "The COVID-19 virus spreads primarily through droplets of saliva or discharge from the nose when an infected person coughs or sneezes, so it’s important that you also practice respiratory etiquette (for example, by coughing into a flexed elbow).\n"+"\n"+"Covid19 Updater is a tracking app where user can see the COVID19's daily information. Here  we used a free API. A user can get the daily updates of COVID19 easily.\n"+"\n"+"THANK YOU!\n"+"\n"+" Stay Home,\n Stay Safe!");
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getContext());
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
       return v;
    }


}