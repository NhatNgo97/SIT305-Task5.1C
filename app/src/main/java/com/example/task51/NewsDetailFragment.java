package com.example.task51;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsDetailFragment extends Fragment implements RelatedNewsRecyclerViewAdapter.RelatedNewsListener {
    public List<News> relatedNewsList;
    public Integer SelectedNewsId;
    private News selectedNews;
    RecyclerView relatedRecyclerView;
    RelatedNewsRecyclerViewAdapter relatedNewsRecyclerViewAdapter;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsDetailFragment newInstance(String param1, String param2) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news_detail, container, false);
        view = v;
        displaySelectedNews(SelectedNewsId);
        DisplayRelatedNews(relatedNewsList);
        return v;
    }

    public void DisplayRelatedNews(List<News> news)
    {
        relatedRecyclerView = view.findViewById(R.id.relatedRecyclerView);
        relatedNewsRecyclerViewAdapter = new RelatedNewsRecyclerViewAdapter(relatedNewsList, this.getActivity(), this);
        relatedRecyclerView.setAdapter(relatedNewsRecyclerViewAdapter);
        relatedRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    public void displaySelectedNews(int index)
    {
        if(selectedNews != null)
        {
            relatedNewsList.add(selectedNews);
            relatedNewsRecyclerViewAdapter.notifyDataSetChanged();
        }

        for(int i = 0; i < relatedNewsList.size(); i++)
        {
            if(relatedNewsList.get(i).getId() == index)
            {
                selectedNews = relatedNewsList.get(i);
                relatedNewsList.remove(selectedNews);
                break;
            }
        }

        ImageView imageview = view.findViewById(R.id.imageView);
        imageview.setImageResource(selectedNews.getImg());
        TextView titleTextView = view.findViewById(R.id.headingTextView);
        titleTextView.setText(selectedNews.getTitle());
        TextView descTextView = view.findViewById(R.id.bodyImageView);
        descTextView.setText(selectedNews.getDescription());
    }

    @Override
    public void OnRelatedClick(int position) {
        displaySelectedNews(relatedNewsList.get(position).getId());
    }
}