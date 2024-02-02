package com.example.expenza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryItem> categoryItemList;
    private Context context;

    public CategoryAdapter(List<CategoryItem> categoryItemList, Context context) {
        this.categoryItemList = categoryItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_expense_income_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryItem categoryItem = categoryItemList.get(position);
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date date=new Date();
        holder.categoryNameTextView.setText(categoryItem.getCategoryName());
        holder.categoryImageView.setImageResource(categoryItem.getCategoryImageResId());
        holder.amountTextView.setText(String.valueOf(categoryItem.getAmount()));
        holder.timestamp.setText(formatter.format(date));
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImageView;
        TextView categoryNameTextView;
        TextView amountTextView;
        TextView timestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImageView = itemView.findViewById(R.id.ivPref);
            categoryNameTextView = itemView.findViewById(R.id.tvCategory);
            amountTextView = itemView.findViewById(R.id.tvAmount);
            timestamp=itemView.findViewById(R.id.tvTimestamp);
        }
    }
}

