package com.danielminami.robotlistmvp.view;

import android.content.Context;
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
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public ImageView imageView;
        public MyViewHolder(View v) {
            super(v);
            textView = (TextView) itemView.findViewById(R.id.textview);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RobotAdapter(List<Robot> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                        int viewType) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new MyViewHolder(inflater.
                inflate(R.layout.recyclerview_items, viewGroup, false));
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position).getName());
        Glide.with(holder.imageView.getContext())
                .load(mDataset.get(position).getImageUrl())
                .into(holder.imageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
