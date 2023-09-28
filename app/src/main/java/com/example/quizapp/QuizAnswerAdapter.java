package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizAnswerAdapter extends RecyclerView.Adapter<QuizAnswerAdapter.QuizAnswerViewHolder> {

    Context context;
    List<String> answerList;

    public QuizAnswerAdapter(List<String> answerList) {
        this.answerList = answerList;
    }

    @NonNull
    @Override
    public QuizAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.answer_item,parent,false);
        return new QuizAnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizAnswerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return answerList.size();
    }

    public class QuizAnswerViewHolder extends RecyclerView.ViewHolder{

        TextView txtAnswer;

        public QuizAnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
        }
    }
}
