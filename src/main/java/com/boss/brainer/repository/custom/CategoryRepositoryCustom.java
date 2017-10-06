package com.boss.brainer.repository.custom;

import com.boss.brainer.domain.mongo.Category;

public interface CategoryRepositoryCustom {

    Category findRandomCategory();
}
