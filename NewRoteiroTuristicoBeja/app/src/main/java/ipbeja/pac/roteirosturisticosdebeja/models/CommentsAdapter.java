package ipbeja.pac.roteirosturisticosdebeja.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.R;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder>{

    private List<Comments> commentsList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CommentsAdapter(Context context){
        this.context = context;
        this.commentsList = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.comment_list_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comments comments = this.commentsList.get(position);
        holder.commentText.setText(comments.getComment());
        User user = new AppRepository(context).getUserById(comments.getUser_id());
        holder.userName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return this.commentsList.size();
    }

    public void updateList(List<Comments> newList){
        this.commentsList = newList;
        notifyDataSetChanged();
    }

    public void addToList(Comments newComment){
        this.commentsList.add(newComment);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView commentText;
        private final TextView userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.commentText = itemView.findViewById(R.id.txtViewComment);
            this.userName = itemView.findViewById(R.id.txtViewUserName);
        }
    }
}
