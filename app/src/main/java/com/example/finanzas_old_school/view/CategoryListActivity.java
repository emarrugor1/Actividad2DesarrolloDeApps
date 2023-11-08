package com.example.finanzas_old_school.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.dto.CategoryDto;
import com.example.finanzas_old_school.util.CategoryListAdapter;
import com.example.finanzas_old_school.util.Mapper;
import com.example.finanzas_old_school.viewmodel.CategoryViewModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CategoryListActivity extends AppCompatActivity {

    private CategoryViewModel categoryViewModel;
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_list_activity);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.reciclerViewListCategory);


        executor.execute(()-> {
            List<CategoryDto> list = categoryViewModel.getAll()
                    .stream()
                    .map(Mapper::categoryEntityToDto)
                    .collect(Collectors.toList());
            CategoryListAdapter adapter = new CategoryListAdapter(list, this);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);

        });


    }
}