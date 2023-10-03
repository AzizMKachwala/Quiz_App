package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizAnswerAdapter extends RecyclerView.Adapter<QuizAnswerAdapter.QuizAnswerViewHolder> {

    Context context;
    List<QuizAnswerModel> quizAnswerModels;
    int questionIndex,selectedPosition = -1;
    
    public QuizAnswerAdapter(Context context, List<QuizAnswerModel> quizAnswerModels, int questionIndex) {
        this.context = context;
        this.quizAnswerModels = quizAnswerModels;
        this.questionIndex = questionIndex;
    }

    @NonNull
    @Override
    public QuizAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.answer_item, parent, false);
        return new QuizAnswerViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull QuizAnswerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        QuizAnswerModel quizAnswerModel = quizAnswerModels.get(position);
        holder.txtAnswer.setText(quizAnswerModel.getAnswer());
        holder.radioButton.setChecked(position == selectedPosition);

        holder.itemView.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();

            // add -> when moved to next after answering the Previous Question then the selected option
            // should be collected and next button should be enabled

            if (context instanceof QuizStartActivity)
                ((QuizStartActivity) context).onAnswerSelected(questionIndex, quizAnswerModel.getAnswer());
        });

        holder.radioButton.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();

            if (context instanceof QuizStartActivity)
                ((QuizStartActivity) context).onAnswerSelected(questionIndex, quizAnswerModel.getAnswer());
        });
    }

    @Override
    public int getItemCount() {
        return quizAnswerModels.size();
    }

    public void clearSelection() {
        selectedPosition = -1;
        notifyDataSetChanged();
    }

    public class QuizAnswerViewHolder extends RecyclerView.ViewHolder {

        RadioButton radioButton;
        TextView txtAnswer;

        public QuizAnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
            radioButton = itemView.findViewById(R.id.radioBtn);

            @SuppressLint("NotifyDataSetChanged") View.OnClickListener clickListener = v -> {
                selectedPosition = getBindingAdapterPosition();
                notifyDataSetChanged();
            };
            itemView.setOnClickListener(clickListener);
            radioButton.setOnClickListener(clickListener);
        }
    }

}