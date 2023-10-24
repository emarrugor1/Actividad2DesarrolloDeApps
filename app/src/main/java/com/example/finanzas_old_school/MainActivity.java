package com.example.finanzas_old_school;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import com.example.finanzas_old_school.model.config.DatabaseConfig;
import com.example.finanzas_old_school.model.dao.CategoryDao;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.CategoryType;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseConfig db = Room.databaseBuilder(getApplicationContext(), DatabaseConfig.class, "finanzas_db").allowMainThreadQueries().build();

        CategoryEntity category = new CategoryEntity();
        category.type = CategoryType.INGRESO;
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


    public void goToMovementsForm(View view){
        Intent intent = new Intent(this, IncomesAndExpensesForm.class);
        startActivity(intent);
    }
}