package com.example.finanzas_old_school.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.finanzas_old_school.model.config.DatabaseConfig;
import com.example.finanzas_old_school.model.dao.CategoryDao;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CategoryRepository {
    private CategoryDao categoryDao;
    private LiveData<List<CategoryEntity>> allCategories;
    private Executor executor = Executors.newSingleThreadExecutor();
    public CategoryRepository(Application application) {
        DatabaseConfig database = DatabaseConfig.getInstance(application);
        categoryDao = database.categoryDao();
        allCategories = categoryDao.getAll();
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {
        return allCategories;
    }

    public void insert(CategoryEntity dato) {
        executor.execute(() -> {
            categoryDao.insert(dato);
        });
    }
    public LiveData<List<CategoryEntity>> getCategoriesByClassification(Clasification clasification) {
        return categoryDao.getCategoriesByClassification(clasification);
    }
    public CategoryEntity getCategoryByConcept(String concept){
        return categoryDao.getCategoryByConcept(concept);
    }
}
