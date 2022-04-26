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

public class RelatedNewsRecyclerViewAdapter extends RecyclerView.Adapter<RelatedNewsRecyclerViewAdapter.ViewHolder>{
    private List<News> _newsList;
    private Context _context;
    private RelatedNewsListener _relatedNewsListener;

    public RelatedNewsRecyclerViewAdapter(List<News> newsList, Context context, RelatedNewsListener relatedNewsListener)
    {
        _newsList = newsList;
        _context = context;
        _relatedNewsListener = relatedNewsListener;
    }

    @NonNull
    @Override
    public RelatedNewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(_context).inflate(R.layout.related_news_row, parent, false);
        return new ViewHolder(itemView, _relatedNewsListener);
    }


    @Override
    public void onBindViewHolder(@NonNull RelatedNewsRecyclerViewAdapter.ViewHolder holder, int position) {
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
        RelatedNewsListener relatedNewsListener;

        public ViewHolder(@NonNull View itemView, RelatedNewsListener relatedNewsListener) {
            super(itemView);
            cardDescTextView = itemView.findViewById(R.id.relatedCardDescTextView);
            cardTitleTextView = itemView.findViewById(R.id.relatedCardTittleTextView);
            cardImage = itemView.findViewById(R.id.relatedCardImage);
            this.relatedNewsListener = relatedNewsListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            relatedNewsListener.OnRelatedClick(getAdapterPosition());
        }
    }
    public interface RelatedNewsListener {
        void OnRelatedClick(int position);
    }
}
