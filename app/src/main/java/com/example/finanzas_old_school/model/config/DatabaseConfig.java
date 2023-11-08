package com.example.finanzas_old_school.model.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finanzas_old_school.model.dao.CategoryDao;
import com.example.finanzas_old_school.model.dao.MovementDao;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.MovementEntity;

@Database(entities = {CategoryEntity.class, MovementEntity.class}, version = 1, exportSchema = false)
public abstract class DatabaseConfig extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract MovementDao movementDao();
    private static volatile DatabaseConfig INSTANCE;

    public static DatabaseConfig getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DatabaseConfig.class, "finanzas_db_v1")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
