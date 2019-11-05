package com.test.forexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcome=findViewById(R.id.txtwelcom);

        Intent intent=getIntent();
        if (getIntent()!=null)
        {
            txtWelcome.setText("Xos gelmisiniz sizin ID "+getIntent().getStringExtra("userid"));
        }


    }


}
