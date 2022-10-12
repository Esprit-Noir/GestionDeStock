package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Article;
import com.espritnoir.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CategoryDto {
    private Integer id;

    private String codeCategory;

    private String designation;

    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
            // TODO throw an exception
        }
        // Mapping Category -> CategoryDto
        return  CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .articles(
                        category.getArticles() != null ?
                                category.getArticles().stream()
                                        .map(ArticleDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null ){
            return null;
            // TODO throw an exception
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCodeCategory(categoryDto.getCodeCategory());
        category.setDesignation(categoryDto.getDesignation());
        category.setArticles(
                categoryDto.getArticles() != null ?
                        categoryDto.getArticles().stream()
                                .map(ArticleDto::toEntity)
                                .collect(Collectors.toList()) : null
        );
        return category;
    }
}
