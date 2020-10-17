package com.example.testbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.testbutton.model.UserView;
import com.example.testbutton.network.NetworkService;
import com.example.testbutton.newsview.NewsCardRecyclerViewAdapter;
import com.example.testbutton.newsview.NewsGridItemDecoration;
import com.example.testbutton.newsview.NewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    private List<UserView> listUsers;
    private UserView userProfile;
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
//        NewsModel model = new NewsModel("https://www.iied.org/sites/default/files/styles/180x180/public/pictures/picture-76-1334667189.jpg?itok=816htO-6", "Emma Wilson");
//        list.add(model);
//        NewsModel model1 = new NewsModel("https://www.neuxtec.com/wp-content/uploads/2017/09/john-kubel-pic.jpg", "John Kubel");
//        list.add(model1);
        NetworkService.getInstance()
                .getJSONApi()
                .list()
                .enqueue(new Callback<List<UserView>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<UserView>> call, @NonNull Response<List<UserView>> response) {
                        if (response.errorBody() == null && response.isSuccessful()) {
                            assert response.body() != null;
                            listUsers = response.body();
                            List<NewsModel> model;
                            for(int i=0; i<listUsers.size(); i++)
                            {
                            list.add(new NewsModel(listUsers.get(i).getImage(), listUsers.get(i).getEmail()));
                            };
                            adapter = new NewsCardRecyclerViewAdapter(list);
                            recyclerView.setAdapter(adapter);

                            int largePadding = 16;
                            int smallPadding = 4;
                            recyclerView.addItemDecoration(new NewsGridItemDecoration(largePadding, smallPadding));

                        } else {
                            listUsers = null;
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<UserView>> call, @NonNull Throwable t) {
                        listUsers = null;
                        t.printStackTrace();
                    }
                });
    }
}