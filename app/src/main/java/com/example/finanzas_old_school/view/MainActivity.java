package com.example.finanzas_old_school.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.dto.CategoryDto;
import com.example.finanzas_old_school.viewmodel.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.reciclerViewListCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategoryDto categoria1 = new CategoryDto();
        categoria1.setConcepto("Gastos de Transporte");
        categoria1.setTipo("Gasto");
        CategoryDto categoria2 = new CategoryDto();
        categoria2.setConcepto("Gastos de Alimentos");
        categoria2.setTipo("Gasto");

        List<CategoryDto> lista = new ArrayList<>();
        lista.add(categoria1);
        lista.add(categoria2);


        MyAdapter adapter = new MyAdapter(lista);
        recyclerView.setAdapter(adapter);
    }
}