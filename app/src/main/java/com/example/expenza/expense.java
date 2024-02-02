package com.example.expenza;

public class expense {
    String Purpose,Category,Timestamp;
    int Amount;

    public expense() {
    }

    public expense(String purpose, String category, String timestamp, int amount) {
        Purpose = purpose;
        Category = category;
        Timestamp = timestamp;
        Amount = amount;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
