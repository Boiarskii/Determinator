package com.determinator.determitator.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.determinator.determitator.R;
import com.determinator.determitator.fragments.QuestionFragment;

import java.util.ArrayList;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String answer = answers.get(position);

        holder.itemView.setEnabled(true);

        QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;

        questionViewHolder.answer.setText(answer);

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
    }

    protected class QuestionViewHolder extends RecyclerView.ViewHolder {

        protected TextView answer;

        public QuestionViewHolder(View itemView, TextView answer) {
            super(itemView);
            this.answer = answer;
        }
    }
}
