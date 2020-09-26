package com.example.testbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClickTest(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Привіт Валера",
                Toast.LENGTH_LONG);
        toast.show();
        Log.e("hello", "-------On click button-----------");
    }
}