package com.example.preferencesexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TestIntent2 extends AppCompatActivity {
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent2);

        Intent intent = getIntent();
        String getIntentExvalue = intent.getStringExtra ("nilaiEditText");
        txtView = findViewById(R.id.txtView);
        txtView.setText(getIntentExvalue);

    }
}