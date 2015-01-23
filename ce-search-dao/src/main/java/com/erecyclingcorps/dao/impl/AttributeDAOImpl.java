package com.erecyclingcorps.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.AttributeDAO;
import com.erecyclingcorps.dao.domain.Attribute;
import com.erecyclingcorps.utils.Constants;

@Repository
public class AttributeDAOImpl extends BaseDAOImpl<Attribute, Serializable> implements AttributeDAO {

    public static final String FIND_ALL_BY_ATTRIBUTE_QUERY = "select get_attribute_values(:attribute,:program,:category)";

    @Override
    protected Class<Attribute> getDataClass() {
        return Attribute.class;
    }

    @SuppressWarnings("unchecked")
    public List<String> findAllByAttribute(Long attribute, Long program, String prioritizationCategory) {
        return	getCurrentSession().createSQLQuery(FIND_ALL_BY_ATTRIBUTE_QUERY+" || '::"+prioritizationCategory+"'").setParameter(Constants.ATTRIBUTE, attribute)
                .setParameter(Constants.PROGRAM, program).setParameter(Constants.CATEGORY, prioritizationCategory).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> findAllAttributeByProgram(Long programId) {
        return (List<Attribute>) getCurrentSession().createCriteria(Attribute.class)
                .createAlias(Constants.PRIORITIZATION_TYPE, Constants.PRIORITIZATION_TYPE)
                .add(Restrictions.eq(Constants.PRIORITIZATIONTYPE_PROGRAM_ID, programId))
                .add(Restrictions.eq(Constants.PRIORITIZATIONTYPE_HIDDEN, false))
                .addOrder(Order.asc(Constants.PRIORITIZATIONTYPE_PRIORITY)).list();
    }

    @Cacheable(value="findAttributeByPK",key="'cesearch.findAttributebyPK-'+#id")
    public Attribute findByPK(Serializable id) throws DataAccessException {
        return super.findByPK(id);
    }
    
    public List<String> findAllByAttribute(Long attribute, Long program, Set<String> prioritizationCategory) {
        List<String> result = new ArrayList<String>();
        for(String category:prioritizationCategory){
            result.addAll(findAllByAttribute(attribute,program,category));
        }
        return  result;
    }

}
