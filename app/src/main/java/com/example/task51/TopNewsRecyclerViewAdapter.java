package com.example.task51;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopNewsRecyclerViewAdapter extends RecyclerView.Adapter<TopNewsRecyclerViewAdapter.ViewHolder> {

    private List<News> _newsList;
    private Context _context;
    private TopNewsListener _topNewsListener;


    public TopNewsRecyclerViewAdapter(List<News> newsList, Context context, TopNewsListener topNewsListener) {
        _newsList = newsList;
        _context = context;
        _topNewsListener = topNewsListener;
    }


    @NonNull
    @Override
    public TopNewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context).inflate(R.layout.top_news_row, parent, false);
        return new ViewHolder(itemView, _topNewsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopNewsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.cardImage.setImageResource(_newsList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return _newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView, descTextView;
        ImageView cardImage;
        TopNewsListener _topNewsListener;

        public ViewHolder(@NonNull View itemView, TopNewsListener topNewsListener) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.relatedCardImage);
            _topNewsListener = topNewsListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view)
        {
            _topNewsListener.OnTopNewsClick(getAdapterPosition());
        }
        

    }

    public interface TopNewsListener {
        void OnTopNewsClick(Integer position);
    }
}
