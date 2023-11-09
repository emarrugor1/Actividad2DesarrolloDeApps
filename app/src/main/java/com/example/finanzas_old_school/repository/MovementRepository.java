package com.example.finanzas_old_school.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.finanzas_old_school.model.config.DatabaseConfig;
import com.example.finanzas_old_school.model.dao.MovementDao;
import com.example.finanzas_old_school.model.entity.MovementEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MovementRepository {
    private final MovementDao movementDao;
    private final LiveData<List<MovementEntity>> allMovements;
    private final Executor executor = Executors.newSingleThreadExecutor(); // Crea un Executor de un solo hilo
    public MovementRepository(Application application) {
        DatabaseConfig database = DatabaseConfig.getInstance(application);
        movementDao = database.movementDao();
        allMovements = movementDao.getAll();
    }

    public LiveData<List<MovementEntity>> getAllMovements() {
        return allMovements;
    }

    public void insert(MovementEntity dato) {
        executor.execute(() -> {
            movementDao.insert(dato);
        });
    }
}
