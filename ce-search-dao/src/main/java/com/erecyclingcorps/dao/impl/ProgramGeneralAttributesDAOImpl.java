package com.erecyclingcorps.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.ProgramGeneralAttributesDAO;
import com.erecyclingcorps.dao.domain.ProgramGenAttribute;
import com.erecyclingcorps.utils.Constants.AttributeCode;

@Repository
public class ProgramGeneralAttributesDAOImpl extends BaseDAOImpl<ProgramGenAttribute, Serializable> implements ProgramGeneralAttributesDAO {


    private static final String ATTRIBUTE_PROGRAM = "program";
    private static final String CEAPIUSERNAME = AttributeCode.CE_APP_USERNAME.getCode();
    private static final String CEAPIPASSWORD = AttributeCode.CE_APP_PASSWORD.getCode();
    private static final String CEAPIURL = AttributeCode.CE_APP_URL.getCode();
    private static final String DEVICEWORTHIMAGEURL = AttributeCode.DEVICEWORTHIMAGEURL.getCode();
    private static final String BUYBACKIMAGEURL = AttributeCode.BUYBACKIMAGEURL.getCode();
    private static final String CE_APP_API_DETAILS_HQL = "select pa.value,a.name from ProgramGenAttribute pa join pa.attribute a with a.name in ('" + CEAPIUSERNAME
            + "','" + CEAPIPASSWORD + "','" + CEAPIURL + "') join pa.program  prg with prg.programName = (:program)";
    private static final String BANNER_DETAILS_HQL = "select pa.value,a.name from ProgramGenAttribute pa join pa.attribute a with a.name in('"
            + DEVICEWORTHIMAGEURL + "','" + BUYBACKIMAGEURL + "')  join pa.program  prg with prg.programName = (:program)";


    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    protected Class<ProgramGenAttribute> getDataClass() {
        return ProgramGenAttribute.class;
    }

    /**
     * Method used to get CE_APP DATA to make rest request to ce-app for model search.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> getAPIData(String program) {
        Query query = getCurrentSession().createQuery(CE_APP_API_DETAILS_HQL);
        query.setParameter(ATTRIBUTE_PROGRAM, program);
        List<Object[]> rows = query.list();
        Map<String, String> apiData = new HashMap<String, String>(3);
        for (Object[] objects : rows) {
            if(((String)objects[1]).equals(CEAPIUSERNAME)){
                apiData.put(CEAPIUSERNAME, (String)objects[0]);
            }else if(((String)objects[1]).equals(CEAPIPASSWORD)){
                apiData.put(CEAPIPASSWORD, (String)objects[0]);
            }else if(((String)objects[1]).equals(CEAPIURL)){
                apiData.put(CEAPIURL, (String)objects[0]);
            }
        }
        return apiData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> getBannerData(String program) {
        Query query = getCurrentSession().createQuery(BANNER_DETAILS_HQL);
        query.setParameter(ATTRIBUTE_PROGRAM, program);
        List<Object[]> rows = query.list();
        Map<String, String> bannerData = new HashMap<String, String>(2);
        for (Object[] objects : rows) {
            if(((String)objects[1]).equals(DEVICEWORTHIMAGEURL)){
                bannerData.put(DEVICEWORTHIMAGEURL.toLowerCase(), (String)objects[0]);
            }else if(((String)objects[1]).equals(BUYBACKIMAGEURL)){
                bannerData.put(BUYBACKIMAGEURL.toLowerCase(), (String)objects[0]);
            }
        }
        return bannerData;
    }



}
