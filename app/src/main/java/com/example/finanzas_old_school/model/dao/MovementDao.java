package com.example.finanzas_old_school.model.dao;

import androidx.lifecycle.LiveData;
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
    LiveData<List<MovementEntity>> getAll();

    @Query("SELECT * FROM movimientos")
    List<MovementEntity> getAllMoves();

    @Query("SELECT * FROM movimientos WHERE id = :id")
    MovementEntity getMovementEntityById(int id);

    @Insert
    void insert(MovementEntity movement);

    @Update
    void update(MovementEntity movement);

    @Delete
    void delete(MovementEntity movement);
}
