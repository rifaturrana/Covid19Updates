package com.asp1.navigationdrawe.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.asp1.navigationdrawe.R;

import java.util.ArrayList;

public class ModelAdapter extends ArrayAdapter<ModelCountry> {
    private Context context;
    ArrayList<ModelCountry> modelCountries;
    public ModelAdapter( Context context, ArrayList<ModelCountry> modelCountries) {
        super(context, R.layout.single_item,modelCountries);
        this.context=context;
        this.modelCountries=modelCountries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(getContext()).inflate(R.layout.single_item,parent,false);
        TextView tv=v.findViewById(R.id.tv);
        ImageView im=v.findViewById(R.id.image);
        im.setImageResource(modelCountries.get(position).getImage());
        tv.setText(modelCountries.get(position).getCountry());
        return v;
    }
}
