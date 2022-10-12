package com.espritnoir.gestiondestock.dto;

import com.espritnoir.gestiondestock.model.MvtStk;
import com.espritnoir.gestiondestock.model.TypeMvtStk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {
    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStk typeMvtStk;

    public MvtStkDto fromEntity(MvtStk mvtStk){
        if (mvtStk == null){
            return null;
            // TODO throw an exception
        }
        // Mapping MvtStk -> MvtStkDto
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .typeMvtStk(mvtStk.getTypeMvtStk())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .build();
    }
    public MvtStk toEntity(MvtStkDto mvtStkDto){
        if (mvtStkDto == null){
            return null;
            // TODO throw an exception
        }
        // Mapping MvtStkDto -> MvtStk
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setTypeMvtStk(mvtStkDto.getTypeMvtStk());
        mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
        return mvtStk;
    }
}
