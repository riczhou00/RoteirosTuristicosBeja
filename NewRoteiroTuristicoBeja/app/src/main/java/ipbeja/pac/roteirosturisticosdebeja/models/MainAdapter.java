package ipbeja.pac.roteirosturisticosdebeja.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Monuments> monumentsList;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnMonumentClickListener listener;

    public MainAdapter(Context context,OnMonumentClickListener listener){
        this.context = context;
        this.monumentsList = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.main_recyclerview_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Monuments monuments = this.monumentsList.get(position);
        Glide.with(this.context).load(monuments.getImage()).into(holder.itemImage);
        holder.itemText.setText(monuments.getMonument_name());

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMonumentClick(monuments.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.monumentsList.size();
    }

    public void updateList(List<Monuments> newList){
        this.monumentsList = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View root;
        private final ImageView itemImage;
        private final TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemImage = itemView.findViewById(R.id.imgViewListItem);
            this.itemText = itemView.findViewById(R.id.txtViewListItem);
            this.root = itemView;
        }
    }

    public interface OnMonumentClickListener{
        void onMonumentClick(long id);
    }
}
