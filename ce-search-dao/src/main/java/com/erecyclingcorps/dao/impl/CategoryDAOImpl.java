package com.erecyclingcorps.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.CategoryDAO;
import com.erecyclingcorps.dao.domain.Category;

@Repository
public class CategoryDAOImpl extends BaseDAOImpl<Category, Serializable> implements CategoryDAO {

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }

}
