package com.example.finanzas_old_school.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.Clasification;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM categorias")
    LiveData<List<CategoryEntity>> getAll();

    @Query("SELECT * FROM categorias")
    List<CategoryEntity> getAllCategories();
    @Query("SELECT * FROM categorias WHERE type = :categoryType")
    LiveData<List<CategoryEntity>> getCategoriesByClassification(Clasification categoryType);
    @Query("SELECT * FROM categorias WHERE concept = :concept")
    CategoryEntity getCategoryByConcept(String concept);
    @Insert
    void insert(CategoryEntity category);

    @Update
    void update(CategoryEntity category);

    @Delete
    void delete(CategoryEntity category);
}
