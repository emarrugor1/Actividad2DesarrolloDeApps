package com.example.finanzas_old_school;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.example.finanzas_old_school.model.config.DatabaseConfig;
import com.example.finanzas_old_school.model.dao.CategoryDao;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbar);
        DatabaseConfig db = Room.databaseBuilder(getApplicationContext(), DatabaseConfig.class, "finanzas_db")
                .allowMainThreadQueries().build();

        CategoryEntity category = new CategoryEntity();
        category.type = Clasification.INGRESO;
        category.concept = "Concepto ejemplo";

        CategoryDao categoryDao = db.categoryDao();
        categoryDao.insert(category);


        List<CategoryEntity> categories = categoryDao.getAll();

        /*
        Tarea tarea = new Tarea();
        tarea.setNombre("Tarea 1");
        tarea.setDescripcion("Realizar una tarea importante");

        db.tareaDao().insert(tarea);
         */
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