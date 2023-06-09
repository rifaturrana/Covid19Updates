package com.asp1.navigationdrawe.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.asp1.navigationdrawe.R;

import java.util.ArrayList;

public class DateAdapter extends ArrayAdapter<ModelDate> {
    private Context context;
    ArrayList<ModelDate> modelDates;
    public DateAdapter( Context context,ArrayList<ModelDate>modelDates) {
        super(context, R.layout.detail_item,modelDates);
        this.context=context;
        this.modelDates=modelDates;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(getContext()).inflate(R.layout.detail_item,parent,false);

        TextView confirmed=v.findViewById(R.id.confirmed);
        confirmed.setText(modelDates.get(position).getConfirmed());
        TextView deaths=v.findViewById(R.id.deaths);
        deaths.setText(modelDates.get(position).getDeaths());
        TextView recovered=v.findViewById(R.id.recovered);
        recovered.setText(modelDates.get(position).getRecovered());
        TextView active=v.findViewById(R.id.active);
        active.setText(modelDates.get(position).getActive());
        TextView date=v.findViewById(R.id.date);
        date.setText(modelDates.get(position).getDate());
        return v;
    }
}
