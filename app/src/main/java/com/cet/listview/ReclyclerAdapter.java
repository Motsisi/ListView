package com.cet.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReclyclerAdapter extends RecyclerView.Adapter<ReclyclerAdapter.ViewHolder> {

    private List<User> userList;
    private ItemClickListener clickListener;

    public ReclyclerAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @NotNull
    @Override
    public ReclyclerAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ReclyclerAdapter.ViewHolder holder, int position) {

        int profileImage = userList.get(position).getImage();
        String profileName = userList.get(position).getName();
        String profileTime = userList.get(position).getTime();
        String profileMessage = userList.get(position).getMessage();

        holder.setData(profileImage,profileName,profileTime,profileMessage);

    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageView;
        private TextView name;
        private TextView time;
        private TextView message;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textViewName);
            time = itemView.findViewById(R.id.textViewClock);
            message = itemView.findViewById(R.id.textViewMessage);
            itemView.setOnClickListener(this);
        }
        public void setData(int profileImage, String profileName, String profileTime, String profileMessage) {
            imageView.setImageResource(profileImage);
            name.setText(profileName);
            time.setText(profileTime);
            message.setText(profileMessage);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
