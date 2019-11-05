package com.test.forexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.forexam.Interfaces.ApiJson;
import com.test.forexam.Model.Accounts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    Button btnRegistr;
    EditText etName,etEmail,etPassword,etStatus;
    ApiJson apiJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        btnRegistr=findViewById(R.id.btn_regist);
        etName=findViewById(R.id.et_name);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);
        etStatus=findViewById(R.id.et_status);



        apiJson=ApiClient.getApiClient().create(ApiJson.class);


        btnRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();

            }
        });





    }

    private void createAccount() {

        String name=etName.getText().toString();
        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();
        String status=etStatus.getText().toString();


        Call<Accounts> call=apiJson.createUser(name,email,password,status);
        call.enqueue(new Callback<Accounts>() {
            @Override
            public void onResponse(Call<Accounts> call, Response<Accounts> response) {
                if (response.isSuccessful()) {
                    Accounts acc=response.body();

                    Toast.makeText(SignUpActivity.this, acc.getName()+" created an user", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onFailure(Call<Accounts> call, Throwable t) {

                Toast.makeText(SignUpActivity.this,t.toString()+ " ERROR",Toast.LENGTH_LONG).show();
            }
        });
    }



}
