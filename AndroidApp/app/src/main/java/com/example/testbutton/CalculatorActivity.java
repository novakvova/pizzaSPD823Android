package com.example.testbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private TextView textView;
    String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textView= findViewById(R.id.textView);
    }
    public void click(View view){
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        text+= b.getText().toString();
        textView.setText(text);
//        Intent intent = new Intent(this, MenuSideBarActivity.class);
//        startActivity(intent);
    }
}