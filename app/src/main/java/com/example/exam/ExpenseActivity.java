package com.example.exam;

import android.net.ParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ExpenseActivity extends AppCompatActivity {
    Button btnSaveExpense;
    EditText editName, editCategory, editDate, editAmount;
    TextView textName, textCategory, textDate, textAmount;
    ListView listViewExpenses;
    ArrayList<Expense> expenseList;
    ExpenseAdapter expenseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expense);

        editName = findViewById(R.id.editExpenseName);
        editCategory = findViewById(R.id.editCategory);
        editDate = findViewById(R.id.editDate);
        editAmount = findViewById(R.id.editAmount);
        btnSaveExpense = findViewById(R.id.btnSaveExpense);


        listViewExpenses = findViewById(R.id.listViewExpenses);
        expenseList = new ArrayList<>();
        expenseAdapter = new ExpenseAdapter(this, expenseList);
        listViewExpenses.setAdapter(expenseAdapter);

        btnSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveExpense();
                }
            });


    }
    public void saveExpense() {
        String name = editName.getText().toString().trim();
        String category = editCategory.getText().toString().trim();
        String date = editDate.getText().toString().trim();
        String amountStr = editAmount.getText().toString().trim();

        if (name.isEmpty() || category.isEmpty() || date.isEmpty() || amountStr.isEmpty()) {
            Toast.makeText(this, "Please Enter something!!!!", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter an amount that is a number, not a string.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidDate(date)) {
            Toast.makeText(this, "Date can't be in the future, please enter a date up to today.", Toast.LENGTH_SHORT).show();
            return;
        }

        Expense expense = new Expense(name, category, date, amount);
        expenseList.add(expense);
        expenseAdapter.notifyDataSetChanged();

        editName.setText("");
        editCategory.setText("");
        editDate.setText("");
        editAmount.setText("");
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        sdf.setLenient(false);
        try {
            Date enteredDate = sdf.parse(date);
            if (enteredDate.after(new Date())) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

}