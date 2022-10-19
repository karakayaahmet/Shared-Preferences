package com.ahmetkarakaya.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.editTextNumber);

        sharedPreferences = this.getSharedPreferences("com.ahmetkarakaya.sharedpreferences", Context.MODE_PRIVATE);

        int stored_age = sharedPreferences.getInt("stored_age",0);

        if (stored_age == 0){
            textView.setText("Your Age: ");
        }

        else {
            textView.setText("Your Age"+stored_age);
        }

    }

    public void save(View view){

        if(!editText.getText().toString().matches("")){
            int age = Integer.parseInt(editText.getText().toString());
            textView.setText("Your Age: "+ age);

            sharedPreferences.edit().putInt("stored_age",age).apply();
        }
    }

    public void delete(View view){
        int storedData = sharedPreferences.getInt("stored_age",0);

        if(storedData != 0){
            sharedPreferences.edit().remove("stored_age");
            textView.setText("Your Age: ");
        }
    }
}