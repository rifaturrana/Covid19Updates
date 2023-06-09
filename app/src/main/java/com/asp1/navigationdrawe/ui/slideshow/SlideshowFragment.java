package com.asp1.navigationdrawe.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;



import com.asp1.navigationdrawe.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.ArrayList;


public class SlideshowFragment extends Fragment {
ListView listView;
private AdView mAdView;
 public static    ArrayList<ModelCountry> modelCountries=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        listView=root.findViewById(R.id.listview);
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        ArrayList<ModelCountry> modelCountries=new ArrayList<>();
        modelCountries.add(new ModelCountry("United States",R.drawable.united));
        modelCountries.add(new ModelCountry("India",R.drawable.india));
        modelCountries.add(new ModelCountry("Brazil",R.drawable.brazil));
        modelCountries.add(new ModelCountry("Russia",R.drawable.russia));
        modelCountries.add(new ModelCountry("Peru",R.drawable.peru));
        modelCountries.add(new ModelCountry("Colombia",R.drawable.colombia));
        modelCountries.add(new ModelCountry("Mexico",R.drawable.mexico));
        modelCountries.add(new ModelCountry("South Africa",R.drawable.southafrica));
        modelCountries.add(new ModelCountry("Spain",R.drawable.spain));
        modelCountries.add(new ModelCountry("Argentina",R.drawable.argentina));
        modelCountries.add(new ModelCountry("France",R.drawable.france));
        modelCountries.add(new ModelCountry("Chile",R.drawable.chile));
        modelCountries.add(new ModelCountry("Iran",R.drawable.iran));
        modelCountries.add(new ModelCountry("United Kingdom",R.drawable.uk));
        modelCountries.add(new ModelCountry("Bangladesh",R.drawable.bangladesh));
        modelCountries.add(new ModelCountry("Saudi Arabia",R.drawable.saudia));
        modelCountries.add(new ModelCountry("Iraq",R.drawable.iraq));
        modelCountries.add(new ModelCountry("Pakistan",R.drawable.pakistan));
        modelCountries.add(new ModelCountry("Turkey",R.drawable.turkey));
        modelCountries.add(new ModelCountry("Italy",R.drawable.italy));
        modelCountries.add(new ModelCountry("Philippines",R.drawable.phillipines));
        modelCountries.add(new ModelCountry("Germany",R.drawable.germany));
        modelCountries.add(new ModelCountry("Indonesia",R.drawable.indonesia));
        modelCountries.add(new ModelCountry("Israel",R.drawable.israel));
        modelCountries.add(new ModelCountry("Ukraine",R.drawable.ukraine));
        modelCountries.add(new ModelCountry("Canada",R.drawable.canada));
        modelCountries.add(new ModelCountry("Bolivia",R.drawable.bolovia));
        modelCountries.add(new ModelCountry("Ecuador",R.drawable.ecuador));
        modelCountries.add(new ModelCountry("Qatar",R.drawable.qatar));
        modelCountries.add(new ModelCountry("Romania",R.drawable.romania));
        modelCountries.add(new ModelCountry("Dominican Republic",R.drawable.dominican));
        modelCountries.add(new ModelCountry("Kazakhstan",R.drawable.kazakhstan));
        modelCountries.add(new ModelCountry("Panama",R.drawable.panama));
        modelCountries.add(new ModelCountry("Belgium",R.drawable.belgium));
        modelCountries.add(new ModelCountry("Morocco",R.drawable.morocco));
        modelCountries.add(new ModelCountry("Egypt",R.drawable.egypt));
        modelCountries.add(new ModelCountry("Kuwait",R.drawable.kuwait));
        ModelAdapter adapter=new ModelAdapter(getContext(),modelCountries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(),SecondActivity.class).putExtra("position",position));

            }
        });
        return root;
    }

}