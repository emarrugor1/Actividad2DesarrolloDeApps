package com.example.finanzas_old_school.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movimientos")
public class MovementEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    public Clasification type;
    public String concept;
    public double value;
    public String date;
    public int categoryId;


}
