package com.example.task51;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements TopNewsRecyclerViewAdapter.TopNewsListener, NewsRecyclerViewAdapter.NewsListener{

    public List<News> newsList;
    public List<News> topNewsList;
    OnFragmentListener callback;
    RecyclerView newsRecyclerView;
    RecyclerView topRecyclerView;
    TopNewsRecyclerViewAdapter topNewsRecyclerViewAdapter;
    NewsRecyclerViewAdapter newsRecyclerViewAdapter;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        view = v;
        newsRecyclerView = view.findViewById(R.id.newsRecyclerView);
        newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(newsList, this.getActivity(), this);
        newsRecyclerView.setAdapter(newsRecyclerViewAdapter);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2, RecyclerView.HORIZONTAL, false));

        topRecyclerView = view.findViewById(R.id.topNewsRecyclerView);
        topNewsRecyclerViewAdapter = new TopNewsRecyclerViewAdapter(topNewsList, this.getActivity(), this);
        topRecyclerView.setAdapter(topNewsRecyclerViewAdapter);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));
        return v;
    }

    @Override
    public void OnNewsClick(int position) {
        callback.openNews(newsList.get(position).getId());
    }

    @Override
    public void OnTopNewsClick(Integer position) {
        callback.openNews(newsList.get(position).getId());
    }

    public interface OnFragmentListener {
        void openNews(int newsStoryId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (OnFragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}