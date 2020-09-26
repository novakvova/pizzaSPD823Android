package com.example.testbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.example.testbutton.network.ImageRequester;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView editImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageRequester = ImageRequester.getInstance();
        editImage = findViewById(R.id.chooseImage);
        imageRequester.setImageFromUrl(editImage,"https://www.regionnews.net.ua/wp-content/uploads/2019/12/zhinky-2.jpg");
    }
    public void onButtonClickTest(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Привіт Валера",
                Toast.LENGTH_LONG);
        toast.show();
        Log.e("hello", "-------On click button-----------");
    }
}