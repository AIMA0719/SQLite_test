package com.example.sqlite_test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.ViewHolder> {

    private static final String TAG = "main";
    private final List<TEST> items;

    public Main_Adapter(List<TEST> items, Context context) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        TEST test = items.get(position);

        Log.e(TAG, "onBindViewHolder: " );

        viewHolder.list.setText(test.getList());
        viewHolder.name.setText(test.getCount());
    }

    @Override
    public int getItemCount() { return items.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView list,name;

        public ViewHolder(View view) {
            super(view);

            list = view.findViewById(R.id.list);
            name = view.findViewById(R.id.name);
        }
    }
}

