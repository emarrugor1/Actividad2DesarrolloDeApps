package com.example.finanzas_old_school.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;
import com.example.finanzas_old_school.model.entity.MovementEntity;
import com.example.finanzas_old_school.util.Util;
import com.example.finanzas_old_school.viewmodel.CategoryViewModel;
import com.example.finanzas_old_school.viewmodel.MovementViewModel;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class IncomesAndExpensesForm extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText conceptField;
    private EditText valueField;
    private EditText movementDate;
    private Switch incomeOrExpenseClassifier;
    private Spinner categorySelectorList;
    private CategoryViewModel categoryViewModel;
    private MovementViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomes_and_expenses_form);
        movementDate = findViewById(R.id.movementDate);
        toolbar = findViewById(R.id.movementsToolbar);
        setSupportActionBar(toolbar);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        viewModel = new ViewModelProvider(this).get(MovementViewModel.class);
        categorySelectorList = findViewById(R.id.categorySelectorList);
        categoryViewModel.getAllCategories().observe(this, categorias -> {
            List<String> nombresCategorias = new ArrayList<>();
            for (CategoryEntity categoria : categorias) {
                nombresCategorias.add(categoria.getConcept());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresCategorias);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categorySelectorList.setAdapter(adapter);
        });
    }
    public void showCalendar(View view){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view1, year, month, dayOfMonth) ->
                        movementDate.setText(
                                MessageFormat.format("{0}/{1}/{2}", dayOfMonth, month, year)),2021,0,1);
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
            Intent intent = new Intent(this, CategoryForm.class);
            startActivity(intent);
        } else if (id == R.id.movementsItem) {
            Intent intent = new Intent(this, this.getClass());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void insertMovement(View view){
        conceptField = findViewById(R.id.conceptField);
        valueField = findViewById(R.id.valueField);
        movementDate = findViewById(R.id.movementDate);
        incomeOrExpenseClassifier = findViewById(R.id.incomeOrExpenseClassifier);
        categorySelectorList = findViewById(R.id.categorySelectorList);

        String concept = conceptField.getText().toString();
        boolean isForExpenses = incomeOrExpenseClassifier.isChecked();

        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setConcept(concept);
        movementEntity.setDate(movementDate.getText().toString());
        movementEntity.setValue(Double.parseDouble(valueField.getText().toString()));

        if (isForExpenses){
            movementEntity.setType(Clasification.GASTO);
        }else {
            movementEntity.setType(Clasification.INGRESO);
        }
        try {
            viewModel.insert(movementEntity);
            Util.getAlertDialog("Guardado correctamente", "Has guardado un Movimiento", IncomesAndExpensesForm.this);
        } catch (Exception e){
            Util.getAlertDialog("Falló el guardado", "Se ha producido un error al guardar", IncomesAndExpensesForm.this);
        }
    }

}