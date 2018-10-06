package com.mirzaadil.technicalassesmenttask.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mirzaadil.technicalassesmenttask.R;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNews;
import com.mirzaadil.technicalassesmenttask.mvp.ui.holder.NYNewsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NYNewsRecyclerViewAdapter extends RecyclerView.Adapter<NYNewsViewHolder> {
    private Context context;
    private List<PopularNews> data;
    private NYNewsRecyclerViewAdapter.ClickListener clickListener;


    public NYNewsRecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList<>();
    }

    public NYNewsRecyclerViewAdapter(Context context, List<PopularNews> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public NYNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NYNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.populer_news_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NYNewsViewHolder holder, int position) {
        holder.textViewAbstract.setText(data
                .get(position).getAbstract());
        holder.textView_ByLine.setText(data.get(position).getByline());
        holder.textView_Soruce.setText(data.get(position).getSource());
        holder.textView_Date.setText(data.get(position).getPublishedDate());
        holder.ImageView(data.get(position), position, holder);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ClickListener {
        void launchIntent(String name);
    }

    public void setItems(List<PopularNews> popularNews) {
        this.data = popularNews;
        notifyDataSetChanged();
    }
}
