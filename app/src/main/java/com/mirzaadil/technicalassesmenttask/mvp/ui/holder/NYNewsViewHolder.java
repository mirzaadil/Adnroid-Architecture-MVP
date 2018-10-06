package com.mirzaadil.technicalassesmenttask.mvp.ui.holder;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mirzaadil.technicalassesmenttask.R;
import com.mirzaadil.technicalassesmenttask.mvp.model.PopularNews;

public class NYNewsViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewAbstract;
    public ImageView imageView_user;
    public TextView textView_ByLine;
    public TextView textView_Soruce;
    public TextView textView_Date;
    public LinearLayout linearLayoutContainer;

    public NYNewsViewHolder(View itemView) {
        super(itemView);

        textViewAbstract = itemView.findViewById(R.id.textview_abstract);
        imageView_user = itemView.findViewById(R.id.imageView_user);
        textView_ByLine = itemView.findViewById(R.id.textviewByLine);
        textView_Soruce = itemView.findViewById(R.id.textviewSource);
        textView_Date = itemView.findViewById(R.id.textviewDate);
        linearLayoutContainer = itemView.findViewById(R.id.ll_container);

        linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   clickListener.launchIntent(data.get(getAdapterPosition()).getTitle());
            }
        });
    }

    public void ImageView(Object obj, final int position, NYNewsViewHolder holder) {

        // Checking the holder instance type.

        if (obj instanceof PopularNews) {
            PopularNews news = (PopularNews) obj;
            if (!TextUtils.isEmpty(news.getMedia().get(0).getMediaMetadata().get(0).getUrl())) {
                Uri imageUri = Uri.parse(news.getMedia().get(0).getMediaMetadata().get(0).getUrl());
                SimpleDraweeView draweeView = (SimpleDraweeView) holder.imageView_user;
                draweeView.setImageURI(imageUri);
                int color = Color.GRAY;
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setBorder(color, 1.0f);
                roundingParams.setRoundAsCircle(true);
                draweeView.getHierarchy().setRoundingParams(roundingParams);

            }

        }
    }

}


