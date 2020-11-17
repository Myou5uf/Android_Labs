package com.udacity.sandwichclub;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RviewAdapter extends RecyclerView.Adapter <RviewAdapter.ViewHolder> {

    private final String[] values;

    RviewAdapter(MainActivity parent, String[] items) {
        values = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.idView.setText(values[position]);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return values.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder  {
        final TextView idView;
        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.textView5);
        }
    }
    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int item = (int) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_POSITION, item);
            context.startActivity(intent);
        }
    };
}
