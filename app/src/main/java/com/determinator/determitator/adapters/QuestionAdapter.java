package com.determinator.determitator.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.determinator.determitator.R;
import com.determinator.determitator.fragments.QuestionFragment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by admin on 04.11.2015.
 */
public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<String> answers;

    QuestionFragment questionFragment;

    public QuestionAdapter(QuestionFragment questionFragment) {
        this.questionFragment = questionFragment;
        answers = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_model, parent, false);
        TextView tvAnswer = (TextView) v.findViewById(R.id.tvAnswer);
        return new QuestionViewHolder(v, tvAnswer);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        String answer = answers.get(position);

        holder.itemView.setEnabled(true);

        QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;

        questionViewHolder.answer.setText(answer);

        questionViewHolder.answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compareWithCorrectVariant(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    public void addAnswer(String answer) {
        answers.add(answer);
        notifyItemInserted(getItemCount() - 1);
    }


    public String getAnswer(int position) {
        return answers.get(position);
    }

    public void removeAnswer(int position) {
        answers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public void removeAllAnswers() {
        answers.clear();
        notifyDataSetChanged();
    }

    private void compareWithCorrectVariant(int position) {
        if (getAnswer(position).equals(questionFragment.correctAnswer)) {
            questionFragment.nextQuestion();
        } else {
            removeAnswer(position);
        }
    }

    protected class QuestionViewHolder extends RecyclerView.ViewHolder {

        protected TextView answer;

        public QuestionViewHolder(View itemView, TextView answer) {
            super(itemView);
            this.answer = answer;
        }
    }
}
