package com.example.finanzas_old_school.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.finanzas_old_school.model.entity.MovementEntity;
import com.example.finanzas_old_school.repository.MovementRepository;

import java.util.List;

public class MovementViewModel extends AndroidViewModel {
    private MovementRepository movementRepository;
    private LiveData<List<MovementEntity>> allMovements;

    public MovementViewModel(Application application) {
        super(application);
        movementRepository = new MovementRepository(application);
        allMovements = movementRepository.getAllMovements();
    }

    public LiveData<List<MovementEntity>> getAllMovements() {
        return allMovements;
    }

    public void insert(MovementEntity dato) {
        movementRepository.insert(dato);
    }
}
