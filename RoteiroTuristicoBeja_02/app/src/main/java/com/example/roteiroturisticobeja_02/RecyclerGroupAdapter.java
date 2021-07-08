package com.example.roteiroturisticobeja_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerGroupAdapter extends RecyclerView.Adapter<RecyclerGroupAdapter.MyViewHolder>{

    private List<Monuments> monumentsList;
    private Context context;

    public RecyclerGroupAdapter(Context ct, List<Monuments> monumentsList){
        this.monumentsList = monumentsList;
        this.context = ct;
    }

    @NonNull
    @Override
    public RecyclerGroupAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_row, parent, false);
        return new RecyclerGroupAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerGroupAdapter.MyViewHolder holder, int position) {
        Monuments monuments = this.monumentsList.get(position);
        holder.txtViewTitle.setText(monuments.getMonument_name());
        //holder.txtViewDescription.setText(monuments.getDescription());
        Glide.with(this.context).load(monuments.getImage()).into(holder.myImage);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupActivity.startActivity(context, monuments.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.monumentsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtViewTitle;
        ImageView myImage;
        View mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtViewTitle = itemView.findViewById(R.id.txtViewTitle);
            this.myImage = itemView.findViewById(R.id.MyImageView);
            this.mainLayout = itemView;
        }

        public TextView getTxtViewTitle() {
            return txtViewTitle;
        }

        public ImageView getMyImage() {
            return myImage;
        }

        public View getMainLayout() {
            return mainLayout;
        }
    }
}
