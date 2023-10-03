package com.example.quizapp;

import java.util.List;

public class QuizQuestionModel {

    String question;
    List<QuizAnswerModel> quizAnswerModels;
    String correctAnswer;

    public QuizQuestionModel(String question, List<QuizAnswerModel> quizAnswerModels, String correctAnswer) {
        this.question = question;
        this.quizAnswerModels = quizAnswerModels;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<QuizAnswerModel> getQuizAnswerModels() {
        return quizAnswerModels;
    }

    public void setQuizAnswerModels(List<QuizAnswerModel> quizAnswerModels) {
        this.quizAnswerModels = quizAnswerModels;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}