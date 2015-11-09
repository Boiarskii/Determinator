package com.determinator.determitator.fragments;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.determinator.determitator.adapters.QuestionAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by admin on 09.11.2015.
 */
public abstract class MainQuestionFragment extends Fragment {

    TextView tvQuestion;

    protected ArrayList<String> fullQuestionList;
    protected ArrayList<String> fullAnswerList;

    public String correctAnswer;

    RecyclerView rvAnswers;

    QuestionAdapter questionAdapter;

    public void nextQuestion() {

        ArrayList<String> arrayListForShuffle = new ArrayList<>();

        questionAdapter.removeAllAnswers();

        correctAnswer = null;

        tvQuestion.setText(fullQuestionList.get(0));
        fullQuestionList.remove(0);

        arrayListForShuffle.add(fullAnswerList.get(0));
        arrayListForShuffle.add(fullAnswerList.get(1));
        arrayListForShuffle.add(fullAnswerList.get(2));

        correctAnswer = arrayListForShuffle.get(0);

        Collections.shuffle(arrayListForShuffle);

        questionAdapter.addAnswer(arrayListForShuffle.get(0));
        questionAdapter.addAnswer(arrayListForShuffle.get(1));
        questionAdapter.addAnswer(arrayListForShuffle.get(2));


        arrayListForShuffle.clear();

        fullAnswerList.remove(0);
        fullAnswerList.remove(0);
        fullAnswerList.remove(0);
    }
}
