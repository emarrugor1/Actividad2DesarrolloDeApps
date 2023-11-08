package com.example.finanzas_old_school.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;
import com.example.finanzas_old_school.repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private CategoryRepository categoryRepository;
    private LiveData<List<CategoryEntity>> allCategories;

    public CategoryViewModel(Application application) {
        super(application);
        categoryRepository = new CategoryRepository(application);
        allCategories = categoryRepository.getAllCategories();
    }

    public LiveData<List<CategoryEntity>> getAllCategories() {
        return allCategories;
    }
    public List<CategoryEntity> getAll() {
        return categoryRepository.getAll();
    }

    public void insert(CategoryEntity dato) {
        categoryRepository.insert(dato);
    }

    public LiveData<List<CategoryEntity>> getCategoriesByClasification(Clasification clasification) {
        return categoryRepository.getCategoriesByClassification(clasification);
    }
    public CategoryEntity getCategoryByConcept(String concept){
        return categoryRepository.getCategoryByConcept(concept);
    }
}
