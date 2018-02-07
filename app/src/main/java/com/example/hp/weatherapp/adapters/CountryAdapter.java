package com.example.hp.weatherapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hp.weatherapp.R;
import com.example.hp.weatherapp._entities._List;
import com.example.hp.weatherapp.interfaces.RecyclerViewOnClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 06.02.2018.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    private List<_List> list;
    private Context context;
    private LayoutInflater inflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;


    public CountryAdapter(Context context, List<_List> list, RecyclerViewOnClickListener recyclerViewOnClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.country_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        String date = sdf.format(new Date(System.currentTimeMillis()));
        _List curr = list.get(position);
        holder.tv_country.setText(curr.getName());
        holder.tv_district.setText(String.valueOf(curr.getMain().getSeaLevel()));
        holder.tv_temp.setText(String.valueOf(curr.getMain().getTemp()));
        holder.tv_date.setText(date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_country;
        private TextView tv_temp;
        private TextView tv_district;
        private TextView tv_date;
        private RelativeLayout rl_row;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_country = itemView.findViewById(R.id.tv_country);
            tv_temp = itemView.findViewById(R.id.tv_temp);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_district = itemView.findViewById(R.id.tv_district);
            rl_row = itemView.findViewById(R.id.relative_l);
            rl_row.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
