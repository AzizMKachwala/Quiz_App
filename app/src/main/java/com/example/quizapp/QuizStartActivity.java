package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class QuizStartActivity extends AppCompatActivity {

    List<QuizQuestionModel> quizQuestionModels = new ArrayList<>();
    List<String> answerList = new ArrayList<>();
    RecyclerView questionRecyclerView;
    QuizQuestionAdapter quizQuestionAdapter;
    TextView txtQuestionNumber, txtTimer;
    Button btnPrevious, btnNext, btnSkip, btnFinish, btnBack;
    ImageView imgBack;
    int currentPosition = 0, correctCount = 0, wrongCount = 0, skipCount = 0;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        questionRecyclerView = findViewById(R.id.questionRecyclerView);
        txtQuestionNumber = findViewById(R.id.txtQuestionNumber);
        txtTimer = findViewById(R.id.txtTimer);

        CountDownTimer countDownTimer = new CountDownTimer(20000, 1000) {
            // for 7 Minutes 60000 * 7 (60,000 MS = 60 Sec)
            public void onTick(long millisUntilFinished) {
                String text = String.format(Locale.getDefault(),"%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60, TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                txtTimer.setText("Time : " + text);
            }

            public void onFinish() {
                showResult();
            }
        };
        countDownTimer.start();

//         To Stop the Scroll of RecyclerView
//        questionRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return true;
//            }
//        });

        quizQuestionModels = QuizDataManager.getQuestionList();
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
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(view -> {
            Intent intent1 = new Intent(QuizStartActivity.this, QuizMainActivity.class);
            startActivity(intent1);
            finish();
        });

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
                Toast.makeText(QuizStartActivity.this, "You can't Skip last Question. Last Question Reached", Toast.LENGTH_SHORT).show();
            }
            updateButtonVisibility();
        });

        btnFinish.setOnClickListener(view -> showResult());

        btnBack.setOnClickListener(view -> {
            Intent intent1 = new Intent(QuizStartActivity.this, QuizMainActivity.class);
            startActivity(intent1);
            finish();
        });
    }

    @SuppressLint("SetTextI18n")
    public void showResult(){

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
            } else {
                skipCount++;
            }
        }

        TextView txtResultTotalQuestion, txtResultCorrectAnswerCount, txtResultWrongAnswerCount, txtResultSkipAnswerCount, txtResultScore, txtResultRemarks;
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

        txtResultTotalQuestion.setText("Total Questions = " + totalQuestions);
        txtResultCorrectAnswerCount.setText("Correct Answers = " + correctCount);
        txtResultWrongAnswerCount.setText("Wrong Question = " + wrongCount);
        txtResultSkipAnswerCount.setText("Skipped Question = " + skipCount);
        txtResultScore.setText("Your Score is " + scorePercentage + "%");

        txtResultRemarks = dialogView.findViewById(R.id.txtResultRemarks);

        if (scorePercentage >= 80) {
            txtResultRemarks.setText("Excellent, You aced the Quiz.");
        } else if (scorePercentage >= 60) {
            txtResultRemarks.setText("Good, You are getting better at it.");
        } else if (scorePercentage >= 40) {
            txtResultRemarks.setText("OK, You should keep up the good work.");
        } else if (scorePercentage >= 20) {
            txtResultRemarks.setText("Bad, you Should Work Hard.");
        } else {
            txtResultRemarks.setText("Very Bad, You Failed the Quiz.");
        }

//            builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        btnOK = dialogView.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent1 = new Intent(QuizStartActivity.this, QuizMainActivity.class);
            startActivity(intent1);
            finish();
        });
    }

    public void onAnswerSelected(int questionIndex, String selectedAnswer) {
        while (answerList.size() <= questionIndex) {
            answerList.add(null);
        }
        btnSkip.setEnabled(false);
        btnNext.setEnabled(true);
        answerList.set(questionIndex, selectedAnswer);
        updateButtonVisibility();

//        for (int i = 0; i < answerList.size(); i++ ){
//            Log.e("## User Answers", answerList.get(i) );
//       }

    }

    public void updateButtonVisibility() {
        int totalQuestions = quizQuestionModels.size();
        String questionNumberText = String.format("(%d/%d)", currentPosition + 1, totalQuestions);
        txtQuestionNumber.setText(questionNumberText);

        btnSkip.setEnabled(answerList.size() <= currentPosition || answerList.get(currentPosition) == null);
        btnNext.setEnabled(answerList.size() > currentPosition && answerList.get(currentPosition) != null);
        btnPrevious.setVisibility(currentPosition > 0 ? View.VISIBLE : View.INVISIBLE);
        btnFinish.setVisibility(currentPosition == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
        btnBack.setVisibility(currentPosition == quizQuestionModels.size() - 1 ? View.VISIBLE : View.INVISIBLE);
    }

    public void enableSkipButton() {
        btnSkip.setEnabled(true);
        btnNext.setEnabled(false);
    }
}