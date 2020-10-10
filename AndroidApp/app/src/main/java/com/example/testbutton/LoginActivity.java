package com.example.testbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testbutton.network.Login;
import com.example.testbutton.network.NetworkService;
import com.example.testbutton.network.Tokens;
import com.example.testbutton.network.utils.CommonUtils;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void saveJWTToken(String token) {
        SharedPreferences prefs;
        SharedPreferences.Editor edit;
        prefs = this.getSharedPreferences("jwtStore", Context.MODE_PRIVATE);
        edit = prefs.edit();
        try {
            edit.putString("token", token);
            Log.i("Login", token);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(View v) {
        final TextInputEditText password = findViewById(R.id.input_password);
        final TextInputEditText email = findViewById(R.id.input_email);
//        if (email.getText().toString() == "" || password.getText().toString() == "") {
////            passwordLayout.setError("Fill all fields!");
//        } else {
////            passwordLayout.setError("");
//        }
        Login m = new Login();
        m.setEmail(email.getText().toString());
        m.setPassword(password.getText().toString());
        CommonUtils.showLoading(this);
        NetworkService.getInstance()
                .getJSONApi()
                .login(m)
                .enqueue(new Callback<Tokens>() {
                    @Override
                    public void onResponse(@NonNull Call<Tokens> call, @NonNull Response<Tokens> response) {
                        CommonUtils.hideLoading();
                        if (response.errorBody() == null && response.isSuccessful()) {
                            Tokens post = response.body();
                            Log.e("Hello", post.getToken());
                            saveJWTToken(post.getToken());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            String problem = "Not valid user";
                            //emailLayout.setError("");
                            //password.setError("Login or password was wrong");
                            //CommonUtils.hideLoading();
                            //passwordLayout.setError("Login or password was wrong");
                            //loginButton.setError("Login or password was wrong");
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Tokens> call, @NonNull Throwable t) {
                        CommonUtils.hideLoading();
                        //textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}