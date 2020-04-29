package com.demotxt.myapp.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demotxt.myapp.myapplication.R;
import com.demotxt.myapp.myapplication.activities.AnimeActivity;
import com.demotxt.myapp.myapplication.model.Cult;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuldeep parshar
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public ArrayList<URL> ar = new ArrayList<URL>();
    RequestOptions option;
    private Context mContext;
    private List<Cult> mData;

    public RecyclerViewAdapter(Context mContext, List<Cult> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_name", mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description", mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio", mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category", mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode", mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating", mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img", "https://i.pinimg.com/originals/d4/60/db/d460db8bb8e8e84ab64c373d2e32d2ca.jpg");

                mContext.startActivity(i);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getStudio());
        holder.tv_category.setText(mData.get(position).getCategorie());


        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(position % 2 == 0 ? "https://i.pinimg.com/originals/d4/60/db/d460db8bb8e8e84ab64c373d2e32d2ca.jpg" : "https://qphs.fs.quoracdn.net/main-qimg-482b9dab177350d9093eedea611a9372").apply(option).into(holder.img_thumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_category = itemView.findViewById(R.id.categorie);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}
