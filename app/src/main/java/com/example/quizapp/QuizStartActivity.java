package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizStartActivity extends AppCompatActivity {
    List<QuizQuestionModel> quizQuestionModels = new ArrayList<>();
    RecyclerView questionRecyclerView;
    List<String> answerList;
    QuizQuestionAdapter quizQuestionAdapter;
    Button btnPrevious, btnNext, btnSkip, btnFinish;
    int current = 0;

    int correctCount = 0, wrongCount = 0, skipCount = 0;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        questionRecyclerView = findViewById(R.id.questionRecyclerView);

        questionRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        quizQuestionModels = new ArrayList<>();
        answerList = new ArrayList<>();

        List<QuizAnswerModel> quizAnswerModels1 = new ArrayList<>();
        quizAnswerModels1.add(new QuizAnswerModel("A"));
        quizAnswerModels1.add(new QuizAnswerModel("B"));
        quizAnswerModels1.add(new QuizAnswerModel("C"));
        quizAnswerModels1.add(new QuizAnswerModel("D"));
        quizQuestionModels.add(new QuizQuestionModel("1. Letter A:", quizAnswerModels1, "A"));

        List<QuizAnswerModel> quizAnswerModels2 = new ArrayList<>();
        quizAnswerModels2.add(new QuizAnswerModel("A"));
        quizAnswerModels2.add(new QuizAnswerModel("B"));
        quizAnswerModels2.add(new QuizAnswerModel("C"));
        quizQuestionModels.add(new QuizQuestionModel("2. Letter B", quizAnswerModels2, "B"));

        List<QuizAnswerModel> quizAnswerModels3 = new ArrayList<>();
        quizAnswerModels3.add(new QuizAnswerModel("A"));
        quizAnswerModels3.add(new QuizAnswerModel("B"));
        quizAnswerModels3.add(new QuizAnswerModel("C"));
        quizAnswerModels3.add(new QuizAnswerModel("D"));
        quizAnswerModels3.add(new QuizAnswerModel("E"));
        quizQuestionModels.add(new QuizQuestionModel("3. Letter C", quizAnswerModels3, "C"));

        List<QuizAnswerModel> quizAnswerModels4 = new ArrayList<>();
        quizAnswerModels4.add(new QuizAnswerModel("A"));
        quizAnswerModels4.add(new QuizAnswerModel("B"));
        quizAnswerModels4.add(new QuizAnswerModel("C"));
        quizAnswerModels4.add(new QuizAnswerModel("D"));
        quizAnswerModels4.add(new QuizAnswerModel("E"));
        quizQuestionModels.add(new QuizQuestionModel("4. Letter D", quizAnswerModels4, "D"));

        quizQuestionAdapter = new QuizQuestionAdapter(quizQuestionModels);
        questionRecyclerView.setLayoutManager(new LinearLayoutManager(QuizStartActivity.this, RecyclerView.HORIZONTAL, false));
        questionRecyclerView.setAdapter(quizQuestionAdapter);

        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);
        btnFinish = findViewById(R.id.btnFinish);
        btnPrevious = findViewById(R.id.btnPrevious);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current > 0) {
                    current--;
                    questionRecyclerView.scrollToPosition(current);
//                    Toast.makeText(QuizStartActivity.this, "Clicked on Previous Button", Toast.LENGTH_SHORT).show();
                }
                updateButtonVisibility();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current < quizQuestionModels.size() - 1) {
                    current++;
                    questionRecyclerView.scrollToPosition(current);
//                    Toast.makeText(QuizStartActivity.this, "Clicked on Next Button", Toast.LENGTH_SHORT).show();
                }
                updateButtonVisibility();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current < quizQuestionModels.size() - 1) {
                    current++;
                    questionRecyclerView.scrollToPosition(current);
//                    Toast.makeText(QuizStartActivity.this, "Clicked on Skip Button", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizStartActivity.this, "Last Question Reached", Toast.LENGTH_SHORT).show();
                }
                updateButtonVisibility();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCounts();
                String message = "Correct: " + correctCount + ", Wrong: " + wrongCount + ", Skip: " + skipCount;
                Toast.makeText(QuizStartActivity.this, "" + message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void calculateCounts() {
        for (QuizQuestionModel question : quizQuestionModels) {
            String selectedAnswer = answerList.get(quizQuestionModels.indexOf(question));
            String correctAnswer = question.getCorrectAnswer();

            if (selectedAnswer == null || selectedAnswer.isEmpty()) {
                skipCount++;
            } else if (selectedAnswer.equals(correctAnswer)) {
                correctCount++;
            } else {
                wrongCount++;
            }
        }
    }

    private void updateButtonVisibility() {
        btnPrevious.setVisibility(current > 0 ? View.VISIBLE : View.INVISIBLE);
        btnNext.setVisibility(current < quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        btnFinish.setVisibility(current == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
    }

}
