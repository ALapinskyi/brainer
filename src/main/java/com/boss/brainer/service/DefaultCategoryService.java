package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.Category;
import com.boss.brainer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DefaultCategoryService implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findRandomCategories(Integer count) {
        List<Category> resultList = new LinkedList<>();

        while(resultList.size() < count){

            Category result = categoryRepository.findRandomCategory();

            if(resultList.stream().noneMatch(category -> category.get_id().equals(result.get_id())))
                resultList.add(result);
        }

        return resultList;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
