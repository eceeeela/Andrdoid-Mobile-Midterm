package com.example.exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {
    public ExpenseAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense expense = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.expense_layout, parent, false);
        }

        TextView name = convertView.findViewById(R.id.textName);
        TextView date = convertView.findViewById(R.id.textDate);
        TextView category = convertView.findViewById(R.id.textCategory);
        TextView amount = convertView.findViewById(R.id.textAmount);

        name.setText(expense.getName());
        category.setText(expense.getCategory());
        date.setText(expense.getDate());
        amount.setText(String.format("%.2f", expense.getAmount()));


        return convertView;
    }
}

