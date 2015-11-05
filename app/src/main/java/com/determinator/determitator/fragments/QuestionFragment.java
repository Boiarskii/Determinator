package com.determinator.determitator.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.determinator.determitator.R;
import com.determinator.determitator.adapters.QuestionAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    TextView tvQuestion;

    ArrayList<String> fullQuestionList;
    ArrayList<String> fullAnswerList;

    String correctAnswer;

    RecyclerView rvAnswers;

    QuestionAdapter questionAdapter;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);

        tvQuestion = (TextView) v.findViewById(R.id.tvQuestion);

        rvAnswers = (RecyclerView) v.findViewById(R.id.rvAnswers);
        rvAnswers.setLayoutManager(new LinearLayoutManager(getActivity()));

        questionAdapter = new QuestionAdapter(this);

        rvAnswers.setAdapter(questionAdapter);

        fullQuestionList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.questions)));
        fullAnswerList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.answers)));

        nextQuestion();

        return v;
    }

    public void nextQuestion() {
        correctAnswer = null;

        tvQuestion.setText(fullQuestionList.get(0));
        fullQuestionList.remove(0);

        questionAdapter.addAnswer(fullAnswerList.get(0));
        questionAdapter.addAnswer(fullAnswerList.get(1));
        questionAdapter.addAnswer(fullAnswerList.get(2));

        correctAnswer = fullAnswerList.get(0);

        fullAnswerList.remove(0);
        fullAnswerList.remove(0);
        fullAnswerList.remove(0);
    }

}