package com.danielminami.robotlistmvp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.danielminami.robotlistmvp.R;
import com.danielminami.robotlistmvp.model.Robot;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.MyViewHolder> {
    private List<Robot> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public MyViewHolder(View v) {
            super(v);
            textView = (TextView) itemView.findViewById(R.id.textViewRobotName);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewRobot);
        }
    }

    public RobotAdapter(List<Robot> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                        int viewType) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new MyViewHolder(inflater.
                inflate(R.layout.recyclerview_items, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(mDataset.get(position).getName());
        holder.imageView.setTag(R.id.imageViewRobot, 101010);
        Glide.with(holder.imageView.getContext())
                .load(mDataset.get(position).getImageUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
