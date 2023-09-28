package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class QuizStartActivity extends AppCompatActivity {
    List<QuizQuestionModel> quizQuestionModels;
    RecyclerView questionRecyclerView;
    List<String> answerList;

    int correctCount = 0, wrongCount = 0, skipCount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        questionRecyclerView = findViewById(R.id.questionRecyclerView);
        quizQuestionModels = new ArrayList<>();
        answerList = new ArrayList<>();



    }
}