package com.asp1.navigationdrawe.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.asp1.navigationdrawe.DetailActivity;
import com.asp1.navigationdrawe.R;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
ListView listView;
    EditText edtSearch;
    ModelClass modelClass;
    SimpleArcLoader loader;
    MyAdapter myAdapter;
    private InterstitialAd mInterstitialAd;

    public static ArrayList<ModelClass> modelClassList=new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
      edtSearch=root.findViewById(R.id.edtSearch);
        listView=root.findViewById(R.id.listview);
        loader=root.findViewById(R.id.loaderCountry);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), DetailActivity.class).putExtra("position",position));

            }
        });
        AdRequest adRequest=new AdRequest.Builder().build();
        mInterstitialAd=new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-4875345024018177/9932671391");
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

        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {

            fetchData();
        }
        else {
            Toast.makeText(getContext(),"Please Enable Internet Connection",Toast.LENGTH_LONG).show();
        }
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                myAdapter.getFilter().filter(s);
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return root;
    }

    private void fetchData() {
        String url="https://disease.sh/v3/covid-19/countries";
        loader.start();
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray= null;
                try {
                    jsonArray = new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject object=jsonArray.getJSONObject(i);
                        String country=object.getString("country");
                        String cases=object.getString("cases");
                        String deaths=object.getString("deaths");
                        String todayCases=object.getString("todayCases");
                        String todayDeaths=object.getString("todayDeaths");
                        String recovered=object.getString("recovered");
                        String todayRecovered=object.getString("todayRecovered");
                        String casesPerMillion=object.getString("casesPerOneMillion");
                        String deathsPerMillion=object.getString("deathsPerOneMillion");
                        JSONObject image=object.getJSONObject("countryInfo");
                        String flagUrl= image.getString("flag");
                        modelClass=new ModelClass(flagUrl,country,cases,todayCases,deaths,todayDeaths,recovered,todayRecovered,casesPerMillion,deathsPerMillion);
                        modelClassList.add(modelClass);


                    }
                    myAdapter=new MyAdapter(getContext(),modelClassList);
                    listView.setAdapter(myAdapter);
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
