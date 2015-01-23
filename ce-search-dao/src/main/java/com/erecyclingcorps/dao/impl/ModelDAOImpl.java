/*
 * ModelDAOImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.ModelDAO;
import com.erecyclingcorps.dao.domain.ModelAttachment;
import com.erecyclingcorps.dao.domain.ProgramManufacturerModel;
import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;
import com.erecyclingcorps.utils.Constants;

/**
 * @author parora
 **/

@Repository
public class ModelDAOImpl extends BaseDAOImpl<ProgramManufacturerModel,Long> implements ModelDAO {


    public static final String TOP_MODEL_QUERY =
            "select mm.manufacturerModelId as id,mm.manufacturerModelId as manufacturerModelId,mm.modelCode as modelcode,mm.modelNumber as label,mm.imageUrl as image from ProgramManufacturerModel pmm "
                    + "join pmm.programCategory pc join pmm.manufacturerModel mm where mm.active='true' and pc.program.programName=:programName order by pmm.searchOrder%"+Constants.MODEL_DELTA;
    public static final String ATTRIBUTE_PROGRAM = "programName";
    public static final String MODEL_ATTACHMENT_QUERY =
            "from ModelAttachment ma left join fetch ma.attachment where ma.attachmentType=:type and ma.manufacturerModel.id=:id";

    @Override
    protected Class<ProgramManufacturerModel> getDataClass() {
        return ProgramManufacturerModel.class;
    }

    /*
     * 
     */
    @Override
    public ModelAttachment getModelAttachment(Long manufacturerModelId, AttachmentType type) {
        return (ModelAttachment) sessionFactory.getCurrentSession().createQuery(MODEL_ATTACHMENT_QUERY).setParameter(Constants.TYPE, type)
                .setParameter(Constants.ID, manufacturerModelId).uniqueResult();
    }

    @Override
    public List<ModelDTO> findModel(ModelSearchDTO modelSearchDTO) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProgramManufacturerModel.class,"pm");
        criteria.createAlias(Constants.MANUFACTURERMODEL, Constants.MANUFACTURERMODEL);
        ProjectionList proList = Projections.projectionList();
        proList.add(Projections.property(Constants.MANUFACTURERMODEL_MANUFACTURERMODELID).as(Constants.ID));
        proList.add(Projections.property(Constants.MANUFACTURERMODEL_MODELCODE).as(Constants.MODELCODE));
        proList.add(Projections.property(Constants.MANUFACTURERMODEL_MODELNUMBER).as(Constants.LABEL));
        proList.add(Projections.property(Constants.MANUFACTURERMODEL_MANUFACTURERMODELID).as(Constants.MANUFACTURERMODELID));
        proList.add(Projections.alias(Projections.sqlProjection(Constants.SEARCH_ORDER_MODULUS,
                new String[] { Constants.SEARCH_ORDER }, new Type[] {IntegerType.INSTANCE}),Constants.SEARCH_ORDER));
        criteria.setProjection(proList);
        criteria.createAlias(Constants.PROGRAMCATEGORY, Constants.PROGRAMCATEGORY);
        criteria.createAlias(Constants.PROGRAMCATEGORY_PROGRAM, Constants.PROGRAM);
        criteria.createAlias(Constants.PROGRAMCATEGORY_CATEGORY, Constants.CATEGORY);

        criteria.add(Restrictions.eq(Constants.PROGRAM_PROGRAMNAME, modelSearchDTO.getProgram()));
        criteria.add(Restrictions.eq(Constants.CATEGORY_CODE, Constants.CELLPHONE));
        criteria.add(Restrictions.eq(Constants.MANUFACTURERMODEL_ACTIVE , true));


        if (StringUtils.isNotBlank(modelSearchDTO.getSearchText()) && StringUtils.isNotEmpty(modelSearchDTO.getSearchText())) {
            StringBuilder modelQuery = new StringBuilder("");
            String[] tokenStr = modelSearchDTO.getSearchText().split(Constants.WHITESPACES);
            for (int i = 0; i < tokenStr.length; i++) {
                if (StringUtils.isNotEmpty(tokenStr[i])) {
                    modelQuery.append(tokenStr[i]).append(Constants.WILD_CHAR);
                    if (i < tokenStr.length - 1) {
                        modelQuery.append(Constants.AND);
                    }
                }
            }
            criteria.add(Restrictions.sqlRestriction(Constants.FIND_MODEL_TSQUERY_RESTRICTION_STARTS + modelQuery
                    + Constants.FIND_MODEL_TSQUERY_RESTRICTION_ENDS));
        } else {
            if (modelSearchDTO.getFilters().keySet().contains(Constants.PRODUCT.toUpperCase())) {
                criteria.add(Restrictions.eq(Constants.MANUFACTURERMODEL_PRODUCT, modelSearchDTO.getFilters().get(Constants.PRODUCT.toUpperCase())));
            }

            if (modelSearchDTO.getFilters().keySet().contains(Constants.CARRIER.toUpperCase())) {
                criteria.add(Restrictions.sqlRestriction("'"+modelSearchDTO.getFilters().get(Constants.CARRIER.toUpperCase()) +"' = ANY ("+(Constants.CARRIER)+")"));
            }

            if (modelSearchDTO.getFilters().keySet().contains(Constants.MANUFACTURER.toUpperCase() )) {
                criteria.createAlias(Constants.MANUFACTURERMODEL_MANUFACTURER, Constants.MANUFACTURER);
                criteria.add(Restrictions.eq(Constants.MANUFACTURER_DESCRIPTION,modelSearchDTO.getFilters().get(Constants.MANUFACTURER.toUpperCase() )));
            }

            if (modelSearchDTO.getFilters().keySet().contains(Constants.PRODUCTFAMILY.toUpperCase())) {
                criteria.add(Restrictions.eq(Constants.MANUFACTURERMODEL_PRODUCTFAMILY, modelSearchDTO.getFilters().get(Constants.PRODUCTFAMILY.toUpperCase())));
            }
        }
        criteria.setResultTransformer(Transformers.aliasToBean(ModelDTO.class));
        if(StringUtils.isNotBlank(modelSearchDTO.getBatchSize())){
            criteria.setMaxResults(Integer.valueOf(modelSearchDTO.getBatchSize()));
        }
        if(StringUtils.isNotBlank(modelSearchDTO.getStartAt())){
            criteria.setFirstResult(Integer.valueOf(modelSearchDTO.getStartAt()));
        }
        criteria.addOrder(Order.asc(Constants.SEARCH_ORDER));
        @SuppressWarnings("unchecked")
        List<ModelDTO> models = criteria.list();
        return models;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ModelDTO> findTopRatedModel(String program) {
        Query query = sessionFactory.getCurrentSession().createQuery(TOP_MODEL_QUERY);
        query.setParameter(ATTRIBUTE_PROGRAM, program);
        return query.setResultTransformer(Transformers.aliasToBean(ModelDTO.class)).setMaxResults(6).list();
    }
}

