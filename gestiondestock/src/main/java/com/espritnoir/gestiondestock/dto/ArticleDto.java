package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.Adresse;
import com.espritnoir.gestiondestock.model.Article;
import com.espritnoir.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {
    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

    public static ArticleDto fromEntity(Article article){
        if (article==null){
            return null;
            //TODO throw an exception
        }
        // Mapping Article -> ArticleDto
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }
    public static Article toEntity(ArticleDto articleDto){
        if (articleDto==null){
            return null;
            //TODO throw an exception
        }
        // Mapping ArticleDto -> Article
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        article.setPhoto(articleDto.getPhoto());

        return  article;
    }
}
