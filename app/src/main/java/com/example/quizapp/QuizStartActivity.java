package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizStartActivity extends AppCompatActivity {

    List<QuizQuestionModel> quizQuestionModels = new ArrayList<>();
    List<String> answerList = new ArrayList<>();
    RecyclerView questionRecyclerView;
    QuizQuestionAdapter quizQuestionAdapter;
    TextView txtQuestionNumber, txtUserName;
    Button btnPrevious, btnNext, btnSkip, btnFinish, btnBack;
    int currentPosition = 0, correctCount = 0, wrongCount = 0, skipCount = 0;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n"})
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

//         To Stop the Scroll of RecyclerView
//        questionRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return true;
//            }
//        });

        quizQuestionModels = QuizDataManager.getQuizQuestions();
        quizQuestionAdapter = new QuizQuestionAdapter(this, quizQuestionModels);

//          To Stop the Scroll of RecyclerView while initialization of it
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
        btnBack = findViewById(R.id.btnBack);

        btnPrevious.setOnClickListener(view -> {
            if (currentPosition > 0) {
                currentPosition--;
                questionRecyclerView.scrollToPosition(currentPosition);
//                  Toast.makeText(QuizStartActivity.this, "Clicked on Previous Button", Toast.LENGTH_SHORT).show();
            }
            updateButtonVisibility();
        });

        btnNext.setOnClickListener(view -> {
            if (currentPosition < quizQuestionModels.size() - 1) {
                currentPosition++;
                questionRecyclerView.scrollToPosition(currentPosition);
//                    Toast.makeText(QuizStartActivity.this, "Clicked on Next Button", Toast.LENGTH_SHORT).show();
            }
            updateButtonVisibility();
        });

        btnSkip.setOnClickListener(view -> {
            if (currentPosition < quizQuestionModels.size() - 1) {
                currentPosition++;
                questionRecyclerView.scrollToPosition(currentPosition);
//                    Toast.makeText(QuizStartActivity.this, "Clicked on Skip Button", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(QuizStartActivity.this, "Last Question Reached", Toast.LENGTH_SHORT).show();
            }
            updateButtonVisibility();
        });

        btnFinish.setOnClickListener(view -> {

//            Toast.makeText(this, "MESSAGE", Toast.LENGTH_SHORT).show();

            correctCount = 0;
            wrongCount = 0;
            skipCount = 0;

            for (int i = 0; i < quizQuestionModels.size(); i++) {
                if (answerList.size() > i) {
                    String selectedAnswer = answerList.get(i);
                    String correctAnswer = quizQuestionModels.get(i).getCorrectAnswer();

                    if (selectedAnswer == null || selectedAnswer.isEmpty()) {
                        skipCount++;
                    } else if (selectedAnswer.equals(correctAnswer)) {
                        correctCount++;
                    } else {
                        wrongCount++;
                    }
                }
            }

            TextView txtDialogUserName, txtResultTotalQuestion, txtResultCorrectAnswerCount, txtResultWrongAnswerCount, txtResultSkipAnswerCount, txtResultScore, txtResultRemarks;
            Button btnOK;
            int totalQuestions = quizQuestionModels.size();
            double scorePercentage = (correctCount * 100) / totalQuestions;

            AlertDialog.Builder builder = new AlertDialog.Builder(QuizStartActivity.this);
            View dialogView = getLayoutInflater().inflate(R.layout.result_dialog_item, null);
            builder.setView(dialogView);

            txtResultTotalQuestion = dialogView.findViewById(R.id.txtResultTotalQuestion);
            txtResultCorrectAnswerCount = dialogView.findViewById(R.id.txtResultCorrectAnswerCount);
            txtResultWrongAnswerCount = dialogView.findViewById(R.id.txtResultWrongAnswerCount);
            txtResultSkipAnswerCount = dialogView.findViewById(R.id.txtResultSkipAnswerCount);
            txtResultScore = dialogView.findViewById(R.id.txtResultScore);
            txtDialogUserName = dialogView.findViewById(R.id.txtDialogUserName);

            txtDialogUserName.setText("Your Result : " + UserName);
            txtResultTotalQuestion.setText("Total Questions = " + totalQuestions);
            txtResultCorrectAnswerCount.setText("Correct Answers = " + correctCount);
            txtResultWrongAnswerCount.setText("Wrong Question = " + wrongCount);
            txtResultSkipAnswerCount.setText("Skipped Question = " + skipCount);
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

//            builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());

            AlertDialog dialog = builder.create();
            dialog.show();

            btnOK = dialogView.findViewById(R.id.btnOK);
            btnOK.setOnClickListener(v -> dialog.dismiss());
        });

        btnBack.setOnClickListener(view -> {
            Intent intent1 = new Intent(QuizStartActivity.this, QuizMainActivity.class);
            startActivity(intent1);
        });
    }

    public void onAnswerSelected(int questionIndex, String selectedAnswer) {
        while (answerList.size() <= questionIndex) {
            answerList.add(null);
        }
        answerList.set(questionIndex, selectedAnswer);

//        for (int i = 0; i < answerList.size(); i++ ){
//            Log.e("## User Answers", answerList.get(i) );
//       }

        btnSkip.setEnabled(false);
        btnNext.setEnabled(true);
    }

    private void updateButtonVisibility() {
        int totalQuestions = quizQuestionModels.size();
        String questionNumberText = String.format("(%d/%d)", currentPosition + 1, totalQuestions);
        txtQuestionNumber.setText(questionNumberText);

        btnNext.setEnabled(false);
        btnSkip.setEnabled(true);
        btnPrevious.setVisibility(currentPosition > 0 ? View.VISIBLE : View.INVISIBLE);
        btnNext.setVisibility(currentPosition < quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        btnFinish.setVisibility(currentPosition == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        btnBack.setVisibility(currentPosition == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
    }
}
