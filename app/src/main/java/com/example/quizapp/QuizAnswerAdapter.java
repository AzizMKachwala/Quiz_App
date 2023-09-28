package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizAnswerAdapter extends RecyclerView.Adapter<QuizAnswerAdapter.QuizAnswerViewHolder> {

    Context context;
    List<QuizAnswerModel> quizAnswerModels;
    int selectedPosition = -1;

    public QuizAnswerAdapter(List<QuizAnswerModel> quizAnswerModels) {
        this.quizAnswerModels = quizAnswerModels;
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
        QuizAnswerModel quizAnswerModel = quizAnswerModels.get(position);
        holder.txtAnswer.setText(quizAnswerModel.getAnswer());
        holder.radioButton.setChecked(position == selectedPosition);


    }

    @Override
    public int getItemCount() {
        return quizAnswerModels.size();
    }

    public class QuizAnswerViewHolder extends RecyclerView.ViewHolder{

        RadioButton radioButton;
        TextView txtAnswer;

        public QuizAnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
            radioButton = itemView.findViewById(R.id.radioBtn);
        }
    }
}
