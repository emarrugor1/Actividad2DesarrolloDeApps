package com.example.finanzas_old_school.util;

import com.example.finanzas_old_school.model.dto.CategoryDto;
import com.example.finanzas_old_school.model.dto.MovementDto;
import com.example.finanzas_old_school.model.entity.CategoryEntity;
import com.example.finanzas_old_school.model.entity.MovementEntity;

public class Mapper {
    private Mapper(){}
    public static CategoryDto categoryEntityToDto(CategoryEntity categoryEntity){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setConcepto(categoryEntity.getConcept());
        categoryDto.setTipo(categoryEntity.getType().name());
        return categoryDto;
    }
    public static MovementDto moveEntityToDto(MovementEntity moveEntity){
        MovementDto movementDto = new MovementDto();
        movementDto.setClase(moveEntity.getType().toString());
        movementDto.setConcepto(moveEntity.getConcept());
        movementDto.setValor(Double.toString(moveEntity.getValue()));
        movementDto.setFecha(moveEntity.getDate());
        return movementDto;
    }

}
