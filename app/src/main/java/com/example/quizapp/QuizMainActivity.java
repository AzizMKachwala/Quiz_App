package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuizMainActivity extends AppCompatActivity {

    Button btnPlay;
    EditText etvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        btnPlay = findViewById(R.id.btnPlay);
        etvUserName = findViewById(R.id.etvUserName);

        btnPlay.setOnClickListener(view -> {
            String UserName = etvUserName.getText().toString().trim();
            if(!UserName.isEmpty()){
                Intent intent = new Intent(QuizMainActivity.this, QuizStartActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(QuizMainActivity.this, "Enter Name First", Toast.LENGTH_SHORT).show();
            }
        });
    }
}