package com.example.finanzas_old_school.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;
import com.example.finanzas_old_school.util.Util;
import com.example.finanzas_old_school.viewmodel.CategoryViewModel;

public class CategoryForm extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText categoryNameTextView;
    private Switch categorySelector;
    private CategoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_form);
        toolbar = findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbar);
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
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
            Intent intent = new Intent(this, this.getClass());
            startActivity(intent);
        } else if (id == R.id.movementsItem) {
            Intent intent = new Intent(this, MovementsForm.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToMovementsForm(View view){
        Intent intent = new Intent(this, CategoryListActivity.class);
        startActivity(intent);
    }
    public void insertCategory(View view){
        categoryNameTextView = findViewById(R.id.categoryNameValue);
        categorySelector = findViewById(R.id.categorySelector);

        String categoryName = categoryNameTextView.getText().toString();
        boolean isForExpenses = categorySelector.isChecked();

        CategoryEntity category = new CategoryEntity();
        category.setConcept(categoryName);
        if (isForExpenses){
            category.setType(Clasification.GASTO);
        }else {
            category.setType(Clasification.INGRESO);
        }
        try {
            viewModel.insert(category);
            Util.getAlertDialog("Guardado correctamente", "Has guardado una Categoría", CategoryForm.this);
        } catch (Exception e){
            Util.getAlertDialog("Falló el guardado", "Se ha producido un error al guardar", CategoryForm.this);
        }
    }

}