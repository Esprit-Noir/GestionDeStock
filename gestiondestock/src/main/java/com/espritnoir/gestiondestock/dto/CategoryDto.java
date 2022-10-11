package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;

    private String codeCategory;

    private String designation;

    private List<ArticleDto> articles;
}
