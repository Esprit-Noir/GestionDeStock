package com.espritnoir.gestiondestock.service.implementation;

import com.espritnoir.gestiondestock.dto.ArticleDto;
import com.espritnoir.gestiondestock.dto.CategoryDto;
import com.espritnoir.gestiondestock.exception.EntityNotFoundException;
import com.espritnoir.gestiondestock.exception.ErrorCodes;
import com.espritnoir.gestiondestock.exception.InvalidEntityException;
import com.espritnoir.gestiondestock.model.Category;
import com.espritnoir.gestiondestock.repository.CategoryRepository;
import com.espritnoir.gestiondestock.service.CategoryService;
import com.espritnoir.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Category is not valid {}", dto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id==null){
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);

        return  Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun categorie avec l'ID = "+ id +" n'est été trouvé dans la base de données",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
                );
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)){
            log.error("Category code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCodeCategory(codeCategory);

        return  Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun categorie avec le code = "+ codeCategory +" n'est été trouvé dans la base de données",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
