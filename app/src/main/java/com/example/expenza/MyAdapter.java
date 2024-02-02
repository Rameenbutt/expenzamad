package com.example.expenza;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new home_fragment();
            case 1:
                return new budget_fragment();
            case 2:
                return new income_fragment();
            case 3:
                return new about_fragment();
            default:
                return new home_fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // Number of tabs
    }
}