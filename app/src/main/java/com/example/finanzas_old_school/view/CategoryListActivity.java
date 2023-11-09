package com.example.finanzas_old_school.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    private Toolbar toolbar;
    private CategoryViewModel categoryViewModel;
    private final Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_list_activity);
        toolbar = findViewById(R.id.toolbarCategoryList);
        setSupportActionBar(toolbar);

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
            Intent intent = new Intent(this, MovementsForm.class);
            startActivity(intent);
        } else if (id == R.id.categoryListItem) {
            Intent intent = new Intent(this, this.getClass());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}