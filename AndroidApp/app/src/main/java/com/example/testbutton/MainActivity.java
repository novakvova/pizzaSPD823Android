package com.example.testbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.example.testbutton.network.ImageRequester;
import com.example.testbutton.network.NetworkService;
import com.example.testbutton.network.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textVtestGet;
    private ImageRequester imageRequester;
    private NetworkImageView editImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e("Semen","----Hello Peter-----");
        //Log.d("slava", "------dispaly----");
        setContentView(R.layout.activity_main);
        imageRequester = ImageRequester.getInstance();
        editImage = findViewById(R.id.chooseImage);
        imageRequester.setImageFromUrl(editImage,"https://n1s2.hsmedia.ru/05/a8/93/05a893a483fdb95c14cb8376cbe108a3/440x326_21_ea602dbd9464a8f541855895da03cc01@690x460_0xc0a8392b_17375271931512042076.jpeg");
        textVtestGet = findViewById(R.id.textVtestGet);
    }

    public void btnClickPlus(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Нажатий плюс", Toast.LENGTH_LONG);
        toast.show();
    }

    public void btnClickcalculator(View v) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
    public void btnlogin(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void TestGet(View v) {
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textVtestGet.append(post.getId() + "\n");
                        textVtestGet.append(post.getUserId() + "\n");
                        textVtestGet.append(post.getTitle() + "\n");
                        textVtestGet.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textVtestGet.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }





//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        final TextView textView = findViewById(R.id.textView);
//
//        NetworkService.getInstance()
//                .getJSONApi()
//                .getPostWithID(1)
//                .enqueue(new Callback<Post>() {
//                    @Override
//                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
//                        Post post = response.body();
//
//                        textView.append(post.getId() + "\n");
//                        textView.append(post.getUserId() + "\n");
//                        textView.append(post.getTitle() + "\n");
//                        textView.append(post.getBody() + "\n");
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
//
//                        textView.append("Error occurred while getting request!");
//                        t.printStackTrace();
//                    }
//                });
//    }




//    private ImageRequester imageRequester;
//    private NetworkImageView editImage;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        imageRequester = ImageRequester.getInstance();
//        editImage = findViewById(R.id.chooseImage);
//        imageRequester.setImageFromUrl(editImage,"https://external-preview.redd.it/dQPogn5h9wC9s-ghGlr_5sLsYYHNeUMmIWRjKNhUUc4.png?auto=webp&s=923cd6b3273fefb49ba546748a7c05e62609902b");
//    }
//    public void onButtonClickTest(View view) {
//        Toast toast = Toast.makeText(getApplicationContext(), "Привіт Валера",
//                Toast.LENGTH_LONG);
//        toast.show();
//        Log.e("hello", "-------On click button-----------");
//    }
}