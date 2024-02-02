package com.example.expenza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class budget_fragment extends Fragment {

    RecyclerView rvExpense;
    ExpenseAdapter Adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_budget_fragment, container, false);
        rvExpense= v.findViewById(R.id.rvExpense);
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Expenses");
        FirebaseRecyclerOptions<expense> options =
                new FirebaseRecyclerOptions.Builder<expense>()
                        .setQuery(query, expense.class)
                        .build();
        Adapter=new ExpenseAdapter(options,this);
        rvExpense.setAdapter(Adapter);

        return v;
    }

    public void onStart() {
        super.onStart();
        Adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        Adapter.stopListening();
    }

}