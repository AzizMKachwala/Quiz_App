package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizStartActivity extends AppCompatActivity {
    List<QuizQuestionModel> quizQuestionModels = new ArrayList<>();
    RecyclerView questionRecyclerView;
    List<String> answerList;
    List<String> userAnswers = new ArrayList<>();
    QuizQuestionAdapter quizQuestionAdapter;
    TextView txtQuestionNumber,txtUserName;
    Button btnPrevious, btnNext, btnSkip, btnFinish;
    int currentPosition = 0;
    int correctCount = 0, wrongCount = 0, skipCount = 0;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        questionRecyclerView = findViewById(R.id.questionRecyclerView);
        txtUserName = findViewById(R.id.txtUserName);
        txtQuestionNumber = findViewById(R.id.txtQuestionNumber);

        Intent intent = getIntent();
        String UserName = intent.getStringExtra("userName");

        txtUserName.setText(UserName);

        // To Stop the Scroll of RecyclerView
//        questionRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @SuppressLint("ClickableViewAccessibility")
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return true;
//            }
//        });

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
        quizAnswerModels6.add(new QuizAnswerModel("F"));
        quizAnswerModels6.add(new QuizAnswerModel("W"));
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

        //  To Stop the Scroll of RecyclerView while initialization of it
        questionRecyclerView.setLayoutManager(new LinearLayoutManager(QuizStartActivity.this, RecyclerView.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        });

        questionRecyclerView.setAdapter(quizQuestionAdapter);

        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);
        btnFinish = findViewById(R.id.btnFinish);
        btnPrevious = findViewById(R.id.btnPrevious);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
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
            @SuppressLint("SetTextI18n")
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
            @SuppressLint("SetTextI18n")
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
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                for (int i = 0; i < quizQuestionModels.size(); i++) {
                    String selectedAnswer = userAnswers.get(i);
                    String correctAnswer = quizQuestionModels.get(i).getCorrectAnswer();
//
//                    if (selectedAnswer == null || selectedAnswer.isEmpty()) {
//                        skipCount++;
//                    } else if (selectedAnswer.equals(correctAnswer)) {
//                        correctCount++;
//                    } else {
//                        wrongCount++;
//                    }
                }

                int totalQuestions = quizQuestionModels.size();
                int scorePercentage = (correctCount * 100) / totalQuestions;

                AlertDialog.Builder builder = new AlertDialog.Builder(QuizStartActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.result_dialog_item, null);
                builder.setView(dialogView);

                TextView txtResultTotalQuestion, txtResultCorrectAnswerCount, txtResultWrongAnswerCount, txtResultSkipAnswerCount, txtResultScore, txtResultRemarks;

                txtResultTotalQuestion = dialogView.findViewById(R.id.txtResultTotalQuestion);
                txtResultTotalQuestion.setText("Total Questions = " + totalQuestions);

                txtResultCorrectAnswerCount = dialogView.findViewById(R.id.txtResultCorrectAnswerCount);
                txtResultCorrectAnswerCount.setText("Correct Answers = " + correctCount);

                txtResultWrongAnswerCount = dialogView.findViewById(R.id.txtResultWrongAnswerCount);
                txtResultWrongAnswerCount.setText("Wrong Question = " + wrongCount);

                txtResultSkipAnswerCount = dialogView.findViewById(R.id.txtResultSkipAnswerCount);
                txtResultSkipAnswerCount.setText("Skipped Question = " + skipCount);

                txtResultScore = dialogView.findViewById(R.id.txtResultScore);
                txtResultScore.setText("Your Score is " + scorePercentage + "%");

                txtResultRemarks = dialogView.findViewById(R.id.txtResultRemarks);

                if (scorePercentage >= 80) {
                    txtResultRemarks.setText("Excellent");
                } else if (scorePercentage >= 60) {
                    txtResultRemarks.setText("Good");
                } else if (scorePercentage >= 40) {
                    txtResultRemarks.setText("OK");
                } else if (scorePercentage >= 20) {
                    txtResultRemarks.setText("Bad");
                } else {
                    txtResultRemarks.setText("Very Bad");
                }

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void updateUserAnswer(int questionIndex, String selectedAnswer) {
        if (questionIndex >= 0 && questionIndex < userAnswers.size()) {
            userAnswers.set(questionIndex, selectedAnswer);
        }
    }

    private void updateButtonVisibility() {
        btnPrevious.setVisibility(currentPosition > 0 ? View.VISIBLE : View.INVISIBLE);
        btnNext.setVisibility(currentPosition < quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        btnFinish.setVisibility(currentPosition == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
    }
}
