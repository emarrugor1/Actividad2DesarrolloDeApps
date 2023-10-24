package com.example.finanzas_old_school.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categorias")
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    public CategoryType type;
    public String concept;
}
