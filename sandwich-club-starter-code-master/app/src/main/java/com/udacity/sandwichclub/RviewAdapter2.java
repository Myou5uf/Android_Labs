package com.udacity.sandwichclub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RviewAdapter2  extends RecyclerView.Adapter <RviewAdapter2.ViewHolder>{

    private final DetailActivity detailActivity;
    private final List<String> values;

    RviewAdapter2(DetailActivity parent, List<String> items) {
        detailActivity = parent;
        values = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.idView.setText(values.get(position));
        holder.itemView.setTag(values.get(position));
    }


    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView;

        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.textView5);

        }

    }

}
