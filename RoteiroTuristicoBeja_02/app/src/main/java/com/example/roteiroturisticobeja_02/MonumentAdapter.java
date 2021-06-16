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

public class MonumentAdapter extends RecyclerView.Adapter<MonumentAdapter.MyViewHolder> {



    String data1[], data2[];
    int images[];
    Context context;

    public MonumentAdapter(Context ct, String s1[], String s2[], int img[]){
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
        holder.txtText1.setText(data1[position]);
        holder.txtText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtText1, txtText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtText1 = itemView.findViewById(R.id.txtTitle);
            txtText2 = itemView.findViewById(R.id.txtDescription);
            myImage = itemView.findViewById(R.id.MyImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
