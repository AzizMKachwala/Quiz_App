package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizQuestionAdapter extends RecyclerView.Adapter<QuizQuestionAdapter.QuizQuestionViewHolder> {

    Context context;
    List<QuizQuestionModel> quizQuestionModels;
    QuizAnswerAdapter quizAnswerAdapter;

    public QuizQuestionAdapter(Context context, List<QuizQuestionModel> quizQuestionModels) {
        this.context = context;
        this.quizQuestionModels = quizQuestionModels;
    }

    @NonNull
    @Override
    public QuizQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.question_item, parent, false);
        return new QuizQuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizQuestionViewHolder holder, @SuppressLint("RecyclerView") int position) {
        QuizQuestionModel quizQuestionModel = quizQuestionModels.get(position);
        holder.txtQuestion.setText(quizQuestionModel.getQuestion());

        quizAnswerAdapter = new QuizAnswerAdapter(context, quizQuestionModel.getQuizAnswerModels(), position);
        holder.answerRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.answerRecyclerView.setAdapter(quizAnswerAdapter);

        holder.btnReset.setOnClickListener(v -> {
            QuizAnswerAdapter quizAnswerAdapter = (QuizAnswerAdapter) holder.answerRecyclerView.getAdapter();
            if (quizAnswerAdapter != null) {
                quizAnswerAdapter.clearSelection();

                if (context instanceof QuizStartActivity) {
                    ((QuizStartActivity) context).enableSkipButton();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return quizQuestionModels.size();
    }

    public static class QuizQuestionViewHolder extends RecyclerView.ViewHolder {

        TextView txtQuestion;
        RecyclerView answerRecyclerView;
        Button btnReset;

        public QuizQuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuestion = itemView.findViewById(R.id.txtQuestion);
            answerRecyclerView = itemView.findViewById(R.id.answerRecyclerView);
            btnReset = itemView.findViewById(R.id.btnReset);
        }
    }
}