package com.example.finanzas_old_school;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.viewmodel.CategoryViewModel;

import java.util.List;

public class CategoryForm extends AppCompatActivity {
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbar);
        CategoryViewModel viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        /*
        CategoryEntity category = new CategoryEntity();
        category.type = Clasification.INGRESO;
        category.concept = "Concepto ejemplo";

        viewModel.insert(category);
         */
        viewModel.getAllCategories().observe(this, new Observer<List<CategoryEntity>>() {
            @Override
            public void onChanged(List<CategoryEntity> datos) {
                // Actualiza la interfaz de usuario con la lista de datos obtenida
                for (CategoryEntity miEntidad : datos) {
                    Log.d("MiApp", "ID: " + miEntidad.id + ", Dato: " + miEntidad.concept);
                }
            }
        });
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
            Intent intent = new Intent(this, IncomesAndExpensesForm.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToMovementsForm(View view){
        Intent intent = new Intent(this, IncomesAndExpensesForm.class);
        startActivity(intent);
    }
}