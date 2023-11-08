package com.example.finanzas_old_school.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "categorias", indices = {@Index(value = "concept", unique = true)})
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    private Clasification type;
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT, name = "concept")
    private String concept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clasification getType() {
        return type;
    }

    public void setType(Clasification type) {
        this.type = type;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

}
