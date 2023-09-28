package com.example.quizapp;

public class QuizAnswerModel {

    String answer;
    Boolean isSelected = false;

    public QuizAnswerModel(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
