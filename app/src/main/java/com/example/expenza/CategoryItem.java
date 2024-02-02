package com.example.expenza;

public class CategoryItem {
    private String categoryName;
    private int categoryImageResId;
    private double amount;

    public CategoryItem(String categoryName, int categoryImageResId, double amount) {
        this.categoryName = categoryName;
        this.categoryImageResId = categoryImageResId;
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryImageResId() {
        return categoryImageResId;
    }

    public double getAmount() {
        return amount;
    }
}
