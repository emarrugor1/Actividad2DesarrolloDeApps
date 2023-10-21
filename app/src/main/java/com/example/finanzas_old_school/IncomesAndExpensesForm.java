package com.example.finanzas_old_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

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
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.navigation_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.goToCategoryForm){
            Toast.makeText(this, "Ir a formulario de categoría", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.goToMovementForm) {
            Toast.makeText(this, "Ir a formulario de movimientos", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

     */
}