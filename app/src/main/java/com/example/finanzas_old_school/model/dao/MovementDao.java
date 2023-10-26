package com.example.finanzas_old_school.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.MovementEntity;

import java.util.List;

@Dao
public interface MovementDao {
    @Query("SELECT * FROM movimientos")
    List<MovementEntity> getAll();

    @Insert
    void insert(MovementEntity movement);

    @Update
    void update(MovementEntity movement);

    @Delete
    void delete(MovementEntity movement);
}
