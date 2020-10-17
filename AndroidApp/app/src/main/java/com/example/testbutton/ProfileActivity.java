package com.example.testbutton;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testbutton.model.UserView;
import com.example.testbutton.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    //private ImageRequester imageRequester;
    //private NetworkImageView editImage;
    private final String BASE_URL = NetworkService.getBaseUrl();
    private UserView userProfile;
    TextView tvProfileEmail;
    TextView tvProfilePhone;
    TextView tvProfileAge;
    TextView tvProfileDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //imageRequester = ImageRequester.getInstance();

        //editImage = findViewById(R.id.chooseImageProfile);
        tvProfileEmail = findViewById(R.id.textProfileEmail);
        tvProfilePhone = findViewById(R.id.textProfilePhone);
        tvProfileAge = findViewById(R.id.textProfileAge);
        tvProfileDescription = findViewById(R.id.textProfileDescription);


        NetworkService.getInstance()
                .getJSONApi()
                .profile()
                .enqueue(new Callback<UserView>() {
                    @Override
                    public void onResponse(@NonNull Call<UserView> call, @NonNull Response<UserView> response) {
                        if (response.errorBody() == null && response.isSuccessful()) {
                            assert response.body() != null;
                            userProfile = response.body();
                            Log.e("User", userProfile.toString());
                            //imageRequester.setImageFromUrl(editImage, BASE_URL + "/images/" + userProfile.getPhoto());
                            tvProfileEmail.setText(userProfile.getEmail());
                            tvProfilePhone.setText(userProfile.getPhone());
                            tvProfileAge.setText(userProfile.getAge());
                            tvProfileDescription.setText(userProfile.getDescription());

                        } else {
                            userProfile = null;
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<UserView> call, @NonNull Throwable t) {
                        userProfile = null;
                        t.printStackTrace();
                    }
                });
    }
}