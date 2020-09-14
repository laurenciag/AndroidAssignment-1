package com.example.preferencesexample2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestLayout extends AppCompatActivity {

    private EditText editText;
    private Button counter;
    private TextView showNumber;
    private Button toast;
    SharedPreferences sharedPreferences;
    int random = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Log.d("log", "createData");
        setContentView(R.layout.activity_test_layout);
        counter = findViewById(R.id.btnCount);
        showNumber = findViewById(R.id.number);
        toast   = findViewById(R.id.btnToast);
        editText = findViewById(R.id.editText);
    }

    //cari cara pas nambah button dan di rotate tidak hilang (sama kaya on restoreinstance)
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            random  = savedInstanceState.getInt("angka");
            showNumber.setText(Integer.toString(savedInstanceState.getInt("angka")));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("angka",random);
        super.onSaveInstanceState(outState);
    }

    public void numberClick(View view) {
        random++;
        showNumber.setText(Integer.toString(random));
    }


}