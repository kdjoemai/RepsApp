package com.example.d44ntje.repsapp.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.d44ntje.repsapp.R;
import com.example.d44ntje.repsapp.ShowListActivity;
import com.example.d44ntje.repsapp.SportItem;

import java.util.List;

/**
 * Created by KaMaL on 26-7-2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.TextViewHolder> {

    private List<SportItem> exercis;
    private Context mcontext;

    public ItemsAdapter(List<SportItem> list, Context context) {
        this.exercis = list;
        this.mcontext = context;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_cell, parent, false);
        TextViewHolder textViewHolder = new TextViewHolder(view);

        return textViewHolder;
    }


    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {

        final SportItem item = exercis.get(position);


        holder.exercisName.setText(item.getName());
        holder.exercisRep.setText("" + item.getRep1());
//            holder.exercisDate.setText(item.getDate());

    }

    @Override
    public int getItemCount() {
        return exercis.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {

        public TextView exercisName, exercisRep, exercisDate;
        public LinearLayout layout;


        public TextViewHolder(View itemView) {
            super(itemView);

            layout = (LinearLayout) itemView.findViewById(R.id.layout);
            exercisName = (TextView) itemView.findViewById(R.id.textExercisName);
            exercisRep = (TextView) itemView.findViewById(R.id.textRep);
//                exercisDate = (TextView) itemView.findViewById(R.id.textDate);
//
//                layout.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//
//                        ((ShowListActivity) mcontext).userItemClick(getAdapterPosition());
//                    }
//                });

        }

    }

}

