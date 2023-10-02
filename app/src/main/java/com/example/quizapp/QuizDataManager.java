package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuizDataManager {

    public static List<QuizQuestionModel> getQuestionList() {
        List<QuizQuestionModel> quizQuestionModels = new ArrayList<>();

        List<QuizAnswerModel> quizAnswerModels1 = new ArrayList<>();
        quizAnswerModels1.add(new QuizAnswerModel("Delhi"));
        quizAnswerModels1.add(new QuizAnswerModel("Ghandhinagar"));
        quizAnswerModels1.add(new QuizAnswerModel("Ahmedabad"));
        quizAnswerModels1.add(new QuizAnswerModel("Mumbai"));
        quizQuestionModels.add(new QuizQuestionModel("1. What is the Capital of India ?", quizAnswerModels1, "Delhi"));

        List<QuizAnswerModel> quizAnswerModels2 = new ArrayList<>();
        quizAnswerModels2.add(new QuizAnswerModel("India"));
        quizAnswerModels2.add(new QuizAnswerModel("Germany"));
        quizAnswerModels2.add(new QuizAnswerModel("America"));
        quizQuestionModels.add(new QuizQuestionModel("2. Gujarat State is Located in which Country :", quizAnswerModels2, "India"));

        List<QuizAnswerModel> quizAnswerModels3 = new ArrayList<>();
        quizAnswerModels3.add(new QuizAnswerModel("5"));
        quizAnswerModels3.add(new QuizAnswerModel("6"));
        quizAnswerModels3.add(new QuizAnswerModel("7"));
        quizAnswerModels3.add(new QuizAnswerModel("8"));
        quizAnswerModels3.add(new QuizAnswerModel("9"));
        quizQuestionModels.add(new QuizQuestionModel("3. How many Wonders of the World are there?", quizAnswerModels3, "7"));

        List<QuizAnswerModel> quizAnswerModels4 = new ArrayList<>();
        quizAnswerModels4.add(new QuizAnswerModel("An Operating System"));
        quizAnswerModels4.add(new QuizAnswerModel("A Web Server"));
        quizAnswerModels4.add(new QuizAnswerModel("A Web Browser"));
        quizAnswerModels4.add(new QuizAnswerModel("A Virtual Machine"));
        quizAnswerModels4.add(new QuizAnswerModel("None of the Above"));
        quizQuestionModels.add(new QuizQuestionModel("4. Android is ", quizAnswerModels4, "An Operating System"));

        List<QuizAnswerModel> quizAnswerModels5 = new ArrayList<>();
        quizAnswerModels5.add(new QuizAnswerModel("Software Development Kit"));
        quizAnswerModels5.add(new QuizAnswerModel("Software Design Kit"));
        quizAnswerModels5.add(new QuizAnswerModel("Signature Development Kit"));
        quizAnswerModels5.add(new QuizAnswerModel("Signature Design Kit"));
        quizQuestionModels.add(new QuizQuestionModel("5. SDK stands for ", quizAnswerModels5, "Software Development Kit"));

        List<QuizAnswerModel> quizAnswerModels6 = new ArrayList<>();
        quizAnswerModels6.add(new QuizAnswerModel("Dynamic Volt Meter"));
        quizAnswerModels6.add(new QuizAnswerModel("Digital Volt Meter"));
        quizAnswerModels6.add(new QuizAnswerModel("Dalvik Volt Meter"));
        quizAnswerModels6.add(new QuizAnswerModel("Dalvik Virtual Machine"));
        quizAnswerModels6.add(new QuizAnswerModel("Digital Virtual Machine"));
        quizQuestionModels.add(new QuizQuestionModel("6. DVM stands for ", quizAnswerModels6, "Dalvik Virtual Machine"));

        List<QuizAnswerModel> quizAnswerModels7 = new ArrayList<>();
        quizAnswerModels7.add(new QuizAnswerModel("Android Phone Kit"));
        quizAnswerModels7.add(new QuizAnswerModel("Android Page Kit"));
        quizAnswerModels7.add(new QuizAnswerModel("Android Package Kit"));
        quizQuestionModels.add(new QuizQuestionModel("7. APK stands for  ", quizAnswerModels7, "Android Package Kit"));

        List<QuizAnswerModel> quizAnswerModels8 = new ArrayList<>();
        quizAnswerModels8.add(new QuizAnswerModel("Application Page Information"));
        quizAnswerModels8.add(new QuizAnswerModel("Application Programming Interface"));
        quizAnswerModels8.add(new QuizAnswerModel("Android Programming Interface"));
        quizAnswerModels8.add(new QuizAnswerModel("Android Page Information"));
        quizQuestionModels.add(new QuizQuestionModel("8. API stands for ", quizAnswerModels8, "Application Programming Interface"));

        List<QuizAnswerModel> quizAnswerModels9 = new ArrayList<>();
        quizAnswerModels9.add(new QuizAnswerModel("Android Debug Bridge"));
        quizAnswerModels9.add(new QuizAnswerModel("Android Delete Bridge"));
        quizAnswerModels9.add(new QuizAnswerModel("Android Destroy Bridge"));
        quizAnswerModels9.add(new QuizAnswerModel("None of the Above"));
        quizQuestionModels.add(new QuizQuestionModel("9. ADB stands for ", quizAnswerModels9, "Android Debug Bridge"));

        List<QuizAnswerModel> quizAnswerModels10 = new ArrayList<>();
        quizAnswerModels10.add(new QuizAnswerModel("Open Health Academy"));
        quizAnswerModels10.add(new QuizAnswerModel("Open Handset Alliance"));
        quizAnswerModels10.add(new QuizAnswerModel("Open Handset Application"));
        quizAnswerModels10.add(new QuizAnswerModel("Open Handset Association"));
        quizQuestionModels.add(new QuizQuestionModel("10. OHA stands for ", quizAnswerModels10, "Open Handset Alliance"));

        return quizQuestionModels;
    }
}
