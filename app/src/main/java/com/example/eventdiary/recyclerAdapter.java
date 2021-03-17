package com.example.eventdiary;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.eventviewHolder> {

    private List<events>eventsList;
    public recyclerAdapter(List<events>eventsList){ this.eventsList = eventsList;
    }
    @NonNull
    @Override
    public eventviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardv,parent,false);
        return new eventviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull eventviewHolder holder, int position) {
        events event=eventsList.get(position);
        holder.tex.setText(event.getTex());
        holder.pic.setImageResource(event.getPic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
    public static class eventviewHolder extends RecyclerView.ViewHolder {

        public TextView tex;
        public ImageView pic;
        public eventviewHolder(View itemView){
        super(itemView);
        tex=itemView.findViewById(R.id.wedTv);
        pic=itemView.findViewById(R.id.pic);
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}

