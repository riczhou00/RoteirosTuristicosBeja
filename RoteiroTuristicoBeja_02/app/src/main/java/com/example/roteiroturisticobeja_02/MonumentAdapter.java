package com.example.roteiroturisticobeja_02;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MonumentAdapter extends RecyclerView.Adapter<MonumentAdapter.MyViewHolder> {

    private List<Monuments> monumentsList;
    private Context context;

    public MonumentAdapter(Context ct, List<Monuments> monumentsList){
        this.monumentsList = monumentsList;
        this.context = ct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view= inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Monuments monuments = this.monumentsList.get(position);
        holder.txtViewTitle.setText(monuments.getMonument_name());
        holder.txtViewDescription.setText(monuments.getDescription());
        Glide.with(this.context).load(monuments.getImage()).into(holder.myImage);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.startActivity(context, monuments.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.monumentsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtViewTitle, txtViewDescription;
        ImageView myImage;
        View mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtViewTitle = itemView.findViewById(R.id.txtViewTitle);
            this.txtViewDescription = itemView.findViewById(R.id.txtViewDescription);
            this.myImage = itemView.findViewById(R.id.MyImageView);
            this.mainLayout = itemView;
        }
    }
}
