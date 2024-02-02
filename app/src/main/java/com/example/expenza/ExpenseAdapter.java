package com.example.expenza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ExpenseAdapter extends FirebaseRecyclerAdapter<expense,ExpenseAdapter.expenseViewHolder> {

    budget_fragment parent;
    public ExpenseAdapter(@NonNull FirebaseRecyclerOptions<expense> options, budget_fragment context) {
        super(options);
        parent=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull expenseViewHolder holder, int position, @NonNull expense model) {
        holder.tvCategory.setText(model.getCategory());
        holder.tvAmount.setText(model.getAmount());
        holder.tvTimestamp.setText(model.getTimestamp());
        if (model.getCategory().equals("Housing")) {
            holder.ivPref.setImageResource(R.drawable.house); // Replace with your housing icon resource
        } else if (model.getCategory().equals("Transportation")) {
            holder.ivPref.setImageResource(R.drawable.tranportation); // Replace with your transportation icon resource
        } else if (model.getCategory().equals("Groceries")) {
            holder.ivPref.setImageResource(R.drawable.groceries); // Replace with your groceries icon resource
        } else if (model.getCategory().equals("Insurance")) {
            holder.ivPref.setImageResource(R.drawable.insurance); // Replace with your insurance icon resource
        } else if (model.getCategory().equals("Personal Care")) {
            holder.ivPref.setImageResource(R.drawable.personalcare); // Replace with your personal care icon resource
        } else if (model.getCategory().equals("Entertainment")) {
            holder.ivPref.setImageResource(R.drawable.entertainment); // Replace with your entertainment icon resource
        } else if (model.getCategory().equals("Education")) {
            holder.ivPref.setImageResource(R.drawable.education); // Replace with your education icon resource
        }

    }

    @NonNull
    @Override
    public expenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_expense_income_design,parent,false);
        return new expenseViewHolder(view);
    }

    public class expenseViewHolder extends RecyclerView.ViewHolder{
        TextView tvTimestamp,tvCategory,tvAmount;
        ImageView ivPref;
        public expenseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory=itemView.findViewById(R.id.tvCategory);
            tvAmount=itemView.findViewById(R.id.tvAmount);
            tvTimestamp=itemView.findViewById(R.id.tvTimestamp);
            ivPref=itemView.findViewById(R.id.ivPref);
        }
    }

}
