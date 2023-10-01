package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuizDataManager {

    public static List<QuizQuestionModel> getQuizQuestions() {
        List<QuizQuestionModel> quizQuestionModels = new ArrayList<>();

        List<QuizAnswerModel> quizAnswerModels1 = new ArrayList<>();
        quizAnswerModels1.add(new QuizAnswerModel("Delhi"));
        quizAnswerModels1.add(new QuizAnswerModel("Ghandhinagar"));
        quizAnswerModels1.add(new QuizAnswerModel("Ahmedabad"));
        quizQuestionModels.add(new QuizQuestionModel("1. What is the Capital of India ?", quizAnswerModels1, "Delhi"));

        List<QuizAnswerModel> quizAnswerModels2 = new ArrayList<>();
        quizAnswerModels2.add(new QuizAnswerModel("India"));
        quizAnswerModels2.add(new QuizAnswerModel("Germany"));
        quizAnswerModels2.add(new QuizAnswerModel("America"));
        quizQuestionModels.add(new QuizQuestionModel("2. Gujarat State is Located in which Country :", quizAnswerModels2, "India"));

        List<QuizAnswerModel> quizAnswerModels3 = new ArrayList<>();
        quizAnswerModels3.add(new QuizAnswerModel("7"));
        quizAnswerModels3.add(new QuizAnswerModel("5"));
        quizAnswerModels3.add(new QuizAnswerModel("8"));
        quizQuestionModels.add(new QuizQuestionModel("3. How many Wonders of the World are there?", quizAnswerModels3, "7"));

        List<QuizAnswerModel> quizAnswerModels4 = new ArrayList<>();
        quizAnswerModels4.add(new QuizAnswerModel("An Operating System"));
        quizAnswerModels4.add(new QuizAnswerModel("A Web Server"));
        quizAnswerModels4.add(new QuizAnswerModel("A Web Browser"));
        quizQuestionModels.add(new QuizQuestionModel("4. Andrdoid is ", quizAnswerModels4, "An Operating System"));

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

        return quizQuestionModels;
    }
}
