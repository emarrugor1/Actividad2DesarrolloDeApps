package com.example.finanzas_old_school.util;

import com.example.finanzas_old_school.model.dto.CategoryDto;
import com.example.finanzas_old_school.model.entity.CategoryEntity;

public class Mapper {
    private Mapper(){}
    public static CategoryDto categoryEntityToDto(CategoryEntity categoryEntity){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setConcepto(categoryEntity.getConcept());
        categoryDto.setTipo(categoryEntity.getType().name());
        return categoryDto;
    }
}
