package com.boss.brainer.service;


import com.boss.brainer.domain.mongo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findRandomCategories(Integer count);

    List<Category> findAll();
}
