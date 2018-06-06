package com.example.cyt.travel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenuViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImgMenuIcon;
    public TextView mTxtMenuName;

    public MainMenuViewHolder(View itemView) {
        super(itemView);
        mImgMenuIcon = itemView.findViewById(R.id.img_menu_icon);
        mTxtMenuName = itemView.findViewById(R.id.txt_menu_name);
    }
}
