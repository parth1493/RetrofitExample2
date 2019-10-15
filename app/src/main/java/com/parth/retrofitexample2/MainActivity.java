package com.parth.retrofitexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parth.retrofitexample2.model.Info;
import com.parth.retrofitexample2.service.GetCountryDataService;
import com.parth.retrofitexample2.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button submit,clear;
    EditText enterinitialCountryName;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        submit = findViewById(R.id.button);
        clear = findViewById(R.id.button2);
        enterinitialCountryName = findViewById(R.id.editText);

        textView.setText("Country Name");

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Country Name");
                enterinitialCountryName.setText("");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContryName();
            }
        });


    }

    public void getContryName() {

        if(!enterinitialCountryName.getText().equals("")){
            GetCountryDataService getCountryDataService = RetrofitInstance.getService();

            Call<Info> call = getCountryDataService.getCountryName(enterinitialCountryName.getText().toString());

            call.enqueue(new Callback<Info>() {
                @Override
                public void onResponse(Call<Info> call, Response<Info> response) {
                    if(response.code() ==  200) {
                        Info info = response.body();
                        textView.setText(info.getName());
                    }
                }

                @Override
                public void onFailure(Call<Info> call, Throwable t) {
                    textView.setText("Country Name");
                }
            });

        }

    }

}
