package com.spring.parkingsystem.services.implementation;

import com.spring.parkingsystem.dtos.category.CategoryFilterDto;
import com.spring.parkingsystem.models.Category;
import com.spring.parkingsystem.repositories.CategoryRepository;
import com.spring.parkingsystem.services.abstraction.CrudService;
import com.spring.parkingsystem.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("categoryMenu")
public class CategoryImplementationService implements CrudService {
    @Autowired
    CategoryRepository categoryRepository;

    private final int rowsInPage = 10;

    @Override
    public Page<Object> getHeader(Integer page, Object filter, Class<?> filterType) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        String id = MapperHelper.getStringField(filter, "id", CategoryFilterDto.class);
        Page<Object> header = categoryRepository.findAll(id, pagination);
        return header;
    }

    @Override
    public Object getUpdate(Object id) {
        Category entity = categoryRepository.findById((String) id).get();
        return entity;
    }

    @Override
    public Object save(Object dto, Class<?> dtoType) {
        Category entity = new Category(
                MapperHelper.getStringField(dto, "id", dtoType),
                MapperHelper.getIntegerField(dto, "tarif", dtoType),
                MapperHelper.getIntegerField(dto, "tariflanjut", dtoType)
        );
        categoryRepository.save(entity);
        return entity;
    }

    @Override
    public Boolean delete(Object id) {
        categoryRepository.deleteById((String) id);
        return true;
    }
}
