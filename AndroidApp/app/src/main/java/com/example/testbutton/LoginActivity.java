package com.example.testbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testbutton.network.Login;
import com.example.testbutton.network.NetworkService;
import com.example.testbutton.network.Tokens;
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
        NetworkService.getInstance()
                .getJSONApi()
                .login(m)
                .enqueue(new Callback<Tokens>() {
                    @Override
                    public void onResponse(@NonNull Call<Tokens> call, @NonNull Response<Tokens> response) {


                        if (response.errorBody() == null && response.isSuccessful()) {
                            //passwordLayout.setError("");
                            //loginButton.setError("");
                            Tokens post = response.body();
                            // Toast toast = Toast.makeText(getApplicationContext(), "All done! your ref token :" + post.getRefreshToken(), Toast.LENGTH_LONG);
                            //toast.show();
                            //saveJWTToken(post.getToken(),post.getRefreshToken());
                            //CommonUtils.hideLoading();
                            //Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            //startActivity(intent);
                        } else {
                            //emailLayout.setError("");
                            //password.setError("Login or password was wrong");
                            //CommonUtils.hideLoading();
                            //passwordLayout.setError("Login or password was wrong");
                            //loginButton.setError("Login or password was wrong");
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Tokens> call, @NonNull Throwable t) {

                        //CommonUtils.hideLoading();
                        //textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}