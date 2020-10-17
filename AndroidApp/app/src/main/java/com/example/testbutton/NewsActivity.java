package com.example.testbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testbutton.newsview.NewsCardRecyclerViewAdapter;
import com.example.testbutton.newsview.NewsGridItemDecoration;
import com.example.testbutton.newsview.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsCardRecyclerViewAdapter adapter;
    private List<NewsModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recycler_view);
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        NewsModel model = new NewsModel("https://www.iied.org/sites/default/files/styles/180x180/public/pictures/picture-76-1334667189.jpg?itok=816htO-6", "Emma Wilson");
        list.add(model);
        NewsModel model1 = new NewsModel("https://www.neuxtec.com/wp-content/uploads/2017/09/john-kubel-pic.jpg", "John Kubel");
        list.add(model1);
        adapter = new NewsCardRecyclerViewAdapter(list);

        recyclerView.setAdapter(adapter);

        int largePadding = 16;
        int smallPadding = 4;
        recyclerView.addItemDecoration(new NewsGridItemDecoration(largePadding, smallPadding));
    }
}