package com.determinator.determitator.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.determinator.determitator.MainActivity;
import com.determinator.determitator.adapters.QuestionAdapter;

import java.util.ArrayList;
import java.util.Collections;

public abstract class MainQuestionFragment extends Fragment {

    TextView tvQuestion;

    ImageView ivToolbar;

    protected ArrayList<String> fullQuestionList;
    protected ArrayList<String> fullAnswerList;
    protected ArrayList<Drawable> fullImageList;

    public String correctAnswer;

    RecyclerView rvAnswers;

    QuestionAdapter questionAdapter;

    public void nextQuestion() {

        if (fullQuestionList.size() > 0) {
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


            if (fullImageList != null) {
                if (fullImageList.size() > 0) {
                    ivToolbar.setImageDrawable(fullImageList.get(0));
                    fullImageList.remove(0);
                }
            } else {
                ivToolbar.setImageResource(android.R.color.transparent);
            }
        } else {
            ((MainActivity) getActivity()).showSnackBar();
        }
    }
}
