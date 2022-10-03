package com.example.apiappp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apiappp.model.URLResponse;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity {


    private EditText eTUrl ;
    private Button btGetShortURL ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTUrl = findViewById(R.id.eTUrl) ;
        btGetShortURL = findViewById(R.id.btGetShortURL) ;

        btGetShortURL.setOnClickListener(view -> {
            String customUrl = eTUrl.getText().toString() ;
            if(!TextUtils.isEmpty(customUrl)) {
                Snackbar.make(btGetShortURL, "URL: " + customUrl, Snackbar.LENGTH_LONG).show();

                APIInterface apiInterface = APIClient.getClient().create(APIInterface.class) ;

                Call<URLResponse> call = apiInterface.getShortURL(customUrl) ;
                call.enqueue(new Callback<URLResponse>() {
                    @Override
                    @EverythingIsNonNull
                    public void onResponse(Call<URLResponse> call, Response<URLResponse> response) {
                        if(response.isSuccessful() && response.body() != null && !TextUtils.isEmpty(response.body().getResultUrl()))
                            eTUrl.setText(response.body().getResultUrl()) ;
                    }

                    @Override
                    @EverythingIsNonNull
                    public void onFailure(Call<URLResponse> call, Throwable t) {

                    }
                }) ;
            }
        });






    }

}