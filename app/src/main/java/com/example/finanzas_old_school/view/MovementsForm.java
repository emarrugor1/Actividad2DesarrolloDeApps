package com.example.finanzas_old_school.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;
import com.example.finanzas_old_school.model.entity.MovementEntity;
import com.example.finanzas_old_school.util.Util;
import com.example.finanzas_old_school.viewmodel.CategoryViewModel;
import com.example.finanzas_old_school.viewmodel.MovementViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MovementsForm extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText conceptField;
    private EditText valueField;
    private EditText movementDate;
    private Switch incomeOrExpenseClassifier;
    private Spinner categorySelectorList;
    private CategoryViewModel categoryViewModel;
    private MovementViewModel viewModel;
    private final Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movements_form);
        movementDate = findViewById(R.id.movementDate);
        toolbar = findViewById(R.id.movementsToolbar);
        setSupportActionBar(toolbar);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        viewModel = new ViewModelProvider(this).get(MovementViewModel.class);

        categorySelectorList = findViewById(R.id.categorySelectorList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySelectorList.setAdapter(adapter);

        incomeOrExpenseClassifier= findViewById(R.id.incomeOrExpenseClassifier);
        incomeOrExpenseClassifier.setOnCheckedChangeListener((buttonView, isChecked) -> {
            LiveData<List<CategoryEntity>> categoriasLiveData = isChecked ?
                    categoryViewModel.getCategoriesByClasification(Clasification.GASTO) :
                    categoryViewModel.getCategoriesByClasification(Clasification.INGRESO);

            categoriasLiveData.observe(this, categories -> {
                adapter.clear();
                for (CategoryEntity category : categories) {
                    adapter.add(category.getConcept());
                }
            });
        });
    }
    public void showCalendar(View view){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year, month, dayOfMonth) -> {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, dayOfMonth);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String formattedDate = sdf.format(selectedDate.getTime());

            movementDate.setText(formattedDate);
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
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
        } else if (id == R.id.categoryListItem) {
            Intent intent = new Intent(this, CategoryListActivity.class);
            startActivity(intent);
        }else if (id == R.id.movementsListItem) {
            Intent intent = new Intent(this, MovementsListActivity.class);
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

        String categoryConcept = categorySelectorList.getSelectedItem().toString();

        executor.execute(() ->{
            CategoryEntity categoryByConcept = categoryViewModel.getCategoryByConcept(categoryConcept);
            int categoryId = categoryByConcept.getId();
            movementEntity.setId(categoryId);
        });

        try {
            viewModel.insert(movementEntity);
            Util.getAlertDialog("Guardado correctamente", "Has guardado un Movimiento", MovementsForm.this);
        } catch (Exception e){
            Util.getAlertDialog("Falló el guardado", "Se ha producido un error al guardar", MovementsForm.this);
        }
    }

}