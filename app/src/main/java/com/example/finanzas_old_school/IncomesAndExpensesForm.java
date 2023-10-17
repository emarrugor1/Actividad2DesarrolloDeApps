package com.example.finanzas_old_school;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class IncomesAndExpensesForm extends AppCompatActivity {

    EditText movementDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomes_and_expenses_form);
        movementDate = findViewById(R.id.movementDate);

    }
    public void showCalendar(View view){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                movementDate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },2021,0,1);
        datePickerDialog.show();
    }
}