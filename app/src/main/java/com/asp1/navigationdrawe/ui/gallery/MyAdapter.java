package com.asp1.navigationdrawe.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.asp1.navigationdrawe.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<ModelClass> {
    private Context context;
    private ArrayList<ModelClass> modelClasses;
    private ArrayList<ModelClass> modelClassesFilter;
    public MyAdapter(Context context, ArrayList<ModelClass>modelClasses) {
        super(context, R.layout.single_item_list,modelClasses);
        this.context=context;
        this.modelClasses=modelClasses;
        this.modelClassesFilter=modelClasses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(getContext()).inflate(R.layout.single_item_list,parent,false);
        TextView country=v.findViewById(R.id.country);
        ImageView imageView=v.findViewById(R.id.image);
        country.setText(modelClassesFilter.get(position).getCountry());
        Glide.with(context).load(modelClassesFilter.get(position).getFlag()).into(imageView);
        return v;
    }
    @Override
    public int getCount() {
        return modelClassesFilter.size();
    }

    @Nullable
    @Override
    public ModelClass getItem(int position) {
        return modelClassesFilter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = modelClasses.size();
                    filterResults.values = modelClasses;

                }else{
                    List<ModelClass> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(ModelClass itemsModel:modelClasses){
                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                modelClassesFilter = (ArrayList<ModelClass>) results.values;
                GalleryFragment.modelClassList = (ArrayList<ModelClass>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
