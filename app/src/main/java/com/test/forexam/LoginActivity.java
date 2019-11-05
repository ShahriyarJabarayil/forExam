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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {
    ApiJson apiJson;
    Button btnLogin,btnGoRegist;
    EditText etName,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiJson=ApiClient.getApiClient().create(ApiJson.class);



        btnLogin=findViewById(R.id.btn_login);
        btnGoRegist=findViewById(R.id.btn_go_regst);
        etName=findViewById(R.id.et_namelogin);
        etPassword=findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
                //allUsers();

                //userlogin1();
            }
        });

        btnGoRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {

        Call<List<Accounts>> call=apiJson.getuser(etName.getText().toString(),etPassword.getText().toString());
        call.enqueue(new Callback<List<Accounts>>() {
            @Override
            public void onResponse(Call<List<Accounts>> call, Response<List<Accounts>> response) {
                if (response.isSuccessful()) {
                    List<Accounts> acc=response.body();
                    if (acc.size()>0) {
                        Toast.makeText(LoginActivity.this, acc.get(0).getId_user() + " Accounts loaded successful", Toast.LENGTH_LONG).show();

                        Intent intent =new Intent(LoginActivity.this,WelcomeActivity.class);
                        intent.putExtra("userid",acc.get(0).getId_user());
                        startActivity(intent);
                    }



                }

            }

            @Override
            public void onFailure(Call<List<Accounts>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, " Error: " + t.toString(), Toast.LENGTH_LONG).show();


            }
        });




    }
    private void allUsers() {
        Call<List<Accounts>> call=apiJson.getUsers();

        call.enqueue(new Callback<List<Accounts>>() {
            @Override
            public void onResponse(Call<List<Accounts>> call, Response<List<Accounts>> response) {
                if (response.isSuccessful()) {
                    //Accounts acc=response.body();
                    Toast.makeText(LoginActivity.this, " Accounts loaded successful", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Accounts>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, " Error: " + t.toString(), Toast.LENGTH_LONG).show();


            }
        });
    }

    private void userlogin1() {
        Call<Accounts> call = apiJson.getuser0(etName.getText().toString(), etPassword.getText().toString());

        call.enqueue(new Callback<Accounts>() {
            @Override
            public void onResponse(Call<Accounts> call, Response<Accounts> response) {
                if (response.isSuccessful()) {
                    //Accounts acc=response.body();
                    Toast.makeText(LoginActivity.this, " Accounts loaded successful", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<Accounts> call, Throwable t) {

                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_LONG).show();


            }
        });
    }




}
