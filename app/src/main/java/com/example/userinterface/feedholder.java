package com.example.userinterface;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class feedholder extends RecyclerView.ViewHolder{
    TextView mtextView,mauthorView;
    ImageView mimageView;
    public feedholder(@NonNull View itemView) {
        super(itemView);
        mtextView= itemView.findViewById(R.id.item);
        mauthorView=itemView.findViewById(R.id.author);
        mimageView=itemView.findViewById(R.id.image);
    }
}

