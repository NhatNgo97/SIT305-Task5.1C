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

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {
    private List<News> _newsList;
    private Context _context;
    private NewsListener _newsListener;

    public NewsRecyclerViewAdapter(List<News> newsList, Context context, NewsListener newsListener)
    {
        _newsList = newsList;
        _context = context;
        _newsListener = newsListener;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(_context).inflate(R.layout.news_row, parent, false);
        return new ViewHolder(itemView, _newsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.cardTitleTextView.setText(_newsList.get(position).getTitle());
        holder.cardDescTextView.setText(_newsList.get(position).getDescription());
        holder.cardImage.setImageResource(_newsList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return _newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cardDescTextView;
        TextView cardTitleTextView;
        ImageView cardImage;
        NewsListener newsListener;

        public ViewHolder(@NonNull View itemView, NewsListener newsListener ) {
            super(itemView);
            cardDescTextView = itemView.findViewById(R.id.cardDescTextView);
            cardTitleTextView = itemView.findViewById(R.id.cardTitleTextView);
            cardImage = itemView.findViewById(R.id.relatedCardImage);
            this.newsListener = newsListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            newsListener.OnNewsClick(getAdapterPosition());
        }
    }

    public interface NewsListener {
        void OnNewsClick(int position);
    }

}
