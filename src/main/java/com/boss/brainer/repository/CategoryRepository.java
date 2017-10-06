package com.boss.brainer.repository;

import com.boss.brainer.domain.mongo.Category;
import com.boss.brainer.repository.custom.CategoryRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String>, CategoryRepositoryCustom{
}
