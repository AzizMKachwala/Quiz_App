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
    int currentPosition = 0;
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
        quizQuestionModels.add(new QuizQuestionModel("1. Letter A:", quizAnswerModels1, "A"));

        List<QuizAnswerModel> quizAnswerModels2 = new ArrayList<>();
        quizAnswerModels2.add(new QuizAnswerModel("B"));
        quizAnswerModels2.add(new QuizAnswerModel("C"));
        quizAnswerModels2.add(new QuizAnswerModel("D"));
        quizQuestionModels.add(new QuizQuestionModel("2. Letter B", quizAnswerModels2, "B"));

        List<QuizAnswerModel> quizAnswerModels3 = new ArrayList<>();
        quizAnswerModels3.add(new QuizAnswerModel("C"));
        quizAnswerModels3.add(new QuizAnswerModel("D"));
        quizAnswerModels3.add(new QuizAnswerModel("E"));
        quizQuestionModels.add(new QuizQuestionModel("3. Letter C", quizAnswerModels3, "C"));

        List<QuizAnswerModel> quizAnswerModels4 = new ArrayList<>();
        quizAnswerModels4.add(new QuizAnswerModel("D"));
        quizAnswerModels4.add(new QuizAnswerModel("E"));
        quizQuestionModels.add(new QuizQuestionModel("4. Letter D", quizAnswerModels4, "D"));

        List<QuizAnswerModel> quizAnswerModels5 = new ArrayList<>();
        quizAnswerModels5.add(new QuizAnswerModel("D"));
        quizAnswerModels5.add(new QuizAnswerModel("E"));
        quizAnswerModels5.add(new QuizAnswerModel("F"));
        quizQuestionModels.add(new QuizQuestionModel("5. Letter E", quizAnswerModels5, "E"));

        List<QuizAnswerModel> quizAnswerModels6 = new ArrayList<>();
        quizAnswerModels6.add(new QuizAnswerModel("D"));
        quizAnswerModels6.add(new QuizAnswerModel("E"));
        quizAnswerModels6.add(new QuizAnswerModel("F"));
        quizAnswerModels6.add(new QuizAnswerModel("W"));
        quizAnswerModels6.add(new QuizAnswerModel("X"));
        quizAnswerModels6.add(new QuizAnswerModel("Y"));
        quizAnswerModels6.add(new QuizAnswerModel("Z"));
        quizQuestionModels.add(new QuizQuestionModel("6. Letter F", quizAnswerModels6, "F"));

        List<QuizAnswerModel> quizAnswerModels7 = new ArrayList<>();
        quizAnswerModels7.add(new QuizAnswerModel("E"));
        quizAnswerModels7.add(new QuizAnswerModel("F"));
        quizAnswerModels7.add(new QuizAnswerModel("G"));
        quizQuestionModels.add(new QuizQuestionModel("7. Letter G", quizAnswerModels7, "G"));

        List<QuizAnswerModel> quizAnswerModels8 = new ArrayList<>();
        quizAnswerModels8.add(new QuizAnswerModel("E"));
        quizAnswerModels8.add(new QuizAnswerModel("F"));
        quizAnswerModels8.add(new QuizAnswerModel("G"));
        quizAnswerModels8.add(new QuizAnswerModel("H"));
        quizQuestionModels.add(new QuizQuestionModel("8. Letter H", quizAnswerModels8, "H"));

        List<QuizAnswerModel> quizAnswerModels9 = new ArrayList<>();
        quizAnswerModels9.add(new QuizAnswerModel("E"));
        quizAnswerModels9.add(new QuizAnswerModel("F"));
        quizAnswerModels9.add(new QuizAnswerModel("G"));
        quizAnswerModels9.add(new QuizAnswerModel("H"));
        quizAnswerModels9.add(new QuizAnswerModel("I"));
        quizQuestionModels.add(new QuizQuestionModel("9. Letter I", quizAnswerModels9, "I"));

        List<QuizAnswerModel> quizAnswerModels10 = new ArrayList<>();
        quizAnswerModels10.add(new QuizAnswerModel("G"));
        quizAnswerModels10.add(new QuizAnswerModel("H"));
        quizAnswerModels10.add(new QuizAnswerModel("I"));
        quizAnswerModels10.add(new QuizAnswerModel("J"));
        quizQuestionModels.add(new QuizQuestionModel("10. Letter J", quizAnswerModels10, "J"));

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
                if (currentPosition > 0) {
                    currentPosition--;
                    questionRecyclerView.scrollToPosition(currentPosition);
//                  Toast.makeText(QuizStartActivity.this, "Clicked on Previous Button", Toast.LENGTH_SHORT).show();
                }
                updateButtonVisibility();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition < quizQuestionModels.size() - 1) {
                    currentPosition++;
                    questionRecyclerView.scrollToPosition(currentPosition);
//                    Toast.makeText(QuizStartActivity.this, "Clicked on Next Button", Toast.LENGTH_SHORT).show();
                }
                updateButtonVisibility();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition < quizQuestionModels.size() - 1) {
                    currentPosition++;
                    questionRecyclerView.scrollToPosition(currentPosition);
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
//                calculateCounts();
                String message = "Correct: " + correctCount + ", Wrong: " + wrongCount + ", Skip: " + skipCount;
                Toast.makeText(QuizStartActivity.this, "" + message, Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void calculateCounts() {
//        for (QuizQuestionModel question : quizQuestionModels) {
//            String selectedAnswer = answerList.get(quizQuestionModels.indexOf(question));
//            String correctAnswer = question.getCorrectAnswer();
//
//            if (selectedAnswer == null || selectedAnswer.isEmpty()) {
//                skipCount++;
//            } else if (selectedAnswer.equals(correctAnswer)) {
//                correctCount++;
//            } else {
//                wrongCount++;
//            }
//        }
//    }

    private void updateButtonVisibility() {
        btnPrevious.setVisibility(currentPosition > 0 ? View.VISIBLE : View.INVISIBLE);
        btnNext.setVisibility(currentPosition < quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        btnFinish.setVisibility(currentPosition == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
    }

}
