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

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends MainQuestionFragment {


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);

        tvQuestion = (TextView) v.findViewById(R.id.tvQuestion);

        rvAnswers = (RecyclerView) v.findViewById(R.id.rvAnswers);
        rvAnswers.setLayoutManager(new LinearLayoutManager(getActivity()));

        questionAdapter = new QuestionAdapter(this);

        rvAnswers.setAdapter(questionAdapter);

        fullQuestionList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.test_questions)));
        fullAnswerList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.test_answers)));

        nextQuestion();


        return v;
    }


}
