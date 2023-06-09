package com.asp1.navigationdrawe.ui.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.asp1.navigationdrawe.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment {
    TextView totalcase, totaldeaths ,cases,deaths,recovered;
    SimpleArcLoader loader;
private AdView mAdView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        totalcase=root.findViewById(R.id.totalcases);
        totaldeaths=root.findViewById(R.id.totalDeaths);
        deaths=root.findViewById(R.id.deaths);
        cases=root.findViewById(R.id.cases);
        recovered=root.findViewById(R.id.totalrecover);
        loader=root.findViewById(R.id.loader);
//BannerAd
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {

        fetchData();
        }
        else {
            Toast.makeText(getContext(),"Please Enable Internet Connection",Toast.LENGTH_LONG).show();
        }

        return root;
    }


    private void fetchData() {
        String url="https://disease.sh/v3/covid-19/all" ;
        loader.start();
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response.toString());


                    totalcase.setText(jsonObject.getString("cases"));
                    totaldeaths.setText(jsonObject.getString("deaths"));
                    cases.setText(jsonObject.getString("todayCases"));
                    deaths.setText(jsonObject.getString("todayDeaths"));
                    recovered.setText(jsonObject.getString("recovered"));
                   // todayRecovered.setText(jsonObject.getString("todayRecovered"));
                    loader.stop();loader.setVisibility(View.GONE);

                } catch (JSONException e) {
                    e.printStackTrace();
                    loader.stop();loader.setVisibility(View.GONE);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loader.stop();loader.setVisibility(View.GONE);


            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }
}