package com.example.preferencesexample2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private Button counter;
    private Button movePage;
    private TextView showNumber;
    SharedPreferences sharedPreferences;
    int random = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Log.d("log", "createData");
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.inputText);
        movePage = findViewById(R.id.movePage);
        counter = findViewById(R.id.counter);
        showNumber = findViewById(R.id.showNumber);
//        text.setText(random);
//        save = findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s1 = sharedPreferences.getString("text", "");
        text.setText(s1);
        Log.d("log", "resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        myEdit.putString("text",
                text.getText().toString());
        myEdit.commit();
        Log.d("log", "stop");

    }

    //cari cara pas nambah button dan di rotate tidak hilang (sama kaya on restoreinstance)
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
//            Log.d("nilai", savedInstanceState.getString("nilai"));
            random  = savedInstanceState.getInt("angka");
            showNumber.setText(Integer.toString(savedInstanceState.getInt("angka")));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("angka",random);
        super.onSaveInstanceState(outState);
//        Log.d("nilai", "kena");
//        outState.putString("nilai", "Hai");
    }

    public void numberClick(View view) {
        random++;
        showNumber.setText(Integer.toString(random));
    }

    public void pageClick(View view) {
        Intent k = new Intent(MainActivity.this, TestIntent2.class);
        k.putExtra("nilaiEditText", "seratus");
        startActivity(k);
    }
}