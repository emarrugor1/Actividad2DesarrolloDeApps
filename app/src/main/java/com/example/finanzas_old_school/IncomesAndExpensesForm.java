package com.example.finanzas_old_school;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IncomesAndExpensesForm extends AppCompatActivity {

    EditText movementDate;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomes_and_expenses_form);
        movementDate = findViewById(R.id.movementDate);
        toolbar = findViewById(R.id.movementsToolbar);
        setSupportActionBar(toolbar);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.categoryItem) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.movementsItem) {
            Intent intent = new Intent(this, this.getClass());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}