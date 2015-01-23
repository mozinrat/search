/*
 * TradeOptionsDAOImpl.java Dec 26, 2014
 * Copyright (c)2014 HYLA Mobile, Inc.
 * U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with eRecyclingCorps, Inc.
 */

package com.erecyclingcorps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.TradeOptionsDAO;
import com.erecyclingcorps.dao.domain.ProgramTradeOptions;
import com.erecyclingcorps.dto.TradeOptionsDTO;

/**
 * @author mkamboj
 */
@Repository
public class TradeOptionsDAOImpl extends BaseDAOImpl<ProgramTradeOptions, Long> implements TradeOptionsDAO {

    private static final String TRADE_OPTIONS = "getProgramTradeOptions";

    @SuppressWarnings("unchecked")
    @Override
    public List<TradeOptionsDTO> getTradeOptions(String program) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery(TRADE_OPTIONS);
        return query.setResultTransformer(Transformers.aliasToBean(TradeOptionsDTO.class)).list();
    }

    @Override
    protected Class<ProgramTradeOptions> getDataClass() {
        return ProgramTradeOptions.class;
    }

}