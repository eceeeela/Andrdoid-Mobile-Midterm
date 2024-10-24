package com.example.exam;

public class Expense {
    private String name;
    private String category;
    private String date;
    private double amount;

    public Expense(String name, String category, String date, double amount) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
