package com.example.finanzas_old_school.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "movimientos")
public class MovementEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    public CategoryType type;
    public String concept;
    public double value;
    public String date;
    public int categoryId;


}
