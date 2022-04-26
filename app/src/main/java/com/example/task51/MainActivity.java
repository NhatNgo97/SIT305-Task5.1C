package com.example.task51;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentListener {
    MainFragment mainFragment;
    FragmentManager fragmentManager;


    String[] titleList = {
            "Woman who streaked during NRL match learns fate after stunt goes viral",
            "Dustin Martin pictured on first day back to full training with Richmond\n",
            "Judge warns Johnny Depp fans to ‘stop laughing’ during his testimony",
            "Sunrise’s Sam Mac spills details on baby’s gender as he and girlfriend Rebecca James prepare for first child",
            "Twitter accepts Elon Musk’s $61 billion bid to buy the platform. Here’s how it could change forever"};
    String[] descList = {
            "Wearing a bra and jeans, Javon Johanson made headlines when her stunt was brought to an end by a security guard’s brutal tackle.",
            "The 30-year-old has linked up with his teammates at Punt Road as he works his way back from personal leave.",
            "‘I’m sorry. What was the question again?’",
            "‘Bec is 21 weeks pregnant so it’s an exciting time and there’s a part that blows my mind’.",
            "The deal brings arguably the internet’s most influential platform under the control of one of the world’s richest people."};
    int[] imageList = {R.drawable.sport, R.drawable.sport, R.drawable.johnny, R.drawable.elon, R.drawable.elon};
    String[] genreList = {"Sport", "Sport", "Entertainment", "Entertainment", "Finance"};
    boolean[] IsTopNewsList = {false, true, false, true, true};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        mainFragment = new MainFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, mainFragment)
                .commit();
        mainFragment.newsList = new ArrayList<>();
        mainFragment.topNewsList = new ArrayList<>();
        for(int i = 0; i < titleList.length; i++)
        {
            News news = new News(i, titleList[i], descList[i], imageList[i], IsTopNewsList[i], genreList[i]);
            mainFragment.newsList.add(news);
            if(news.isTopNews())
            {
                mainFragment.topNewsList.add(news);
            }
        }

    }

    @Override
    public void openNews(int newsId) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.mainFragment, newsDetailFragment)
                .addToBackStack(null)
                .commit();

        newsDetailFragment.relatedNewsList = new ArrayList<>();

        for(int i = 0; i < titleList.length; i++)
        {
            News news = new News(i, titleList[i], descList[i], imageList[i], IsTopNewsList[i], genreList[i]);
            if(news.getGenre().equals(genreList[newsId]))
            {
                newsDetailFragment.relatedNewsList.add(news);
            }
        }
        newsDetailFragment.SelectedNewsId = newsId;

    }

}