package com.erecyclingcorps.dao.impl;

import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.LabelConstantDAO;
import com.erecyclingcorps.dao.domain.Label;

@Repository("labelConstantDAO")
public class LabelConstantDAOImpl extends BaseDAOImpl<Label,Long> implements LabelConstantDAO {

    private static final String HQL = "select value from Label where code in :code";
    @Override
    protected Class<Label> getDataClass() {
        return Label.class;
    }

    @Override
    public String findLabelConstantByCode(String code){            
        return (String)sessionFactory.getCurrentSession().createQuery(HQL).setParameter("code", code ).list().get(0);
    }

}
