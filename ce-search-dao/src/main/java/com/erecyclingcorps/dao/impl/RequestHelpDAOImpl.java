package com.erecyclingcorps.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.RequestHelpDAO;
import com.erecyclingcorps.dao.domain.ContactUs;
import com.erecyclingcorps.dto.ContactUsDTO;
import com.erecyclingcorps.utils.Constants;

@Repository
public class RequestHelpDAOImpl extends BaseDAOImpl<ContactUs, Serializable> implements RequestHelpDAO {

    private static final String HQLWIDGETS = "select a.name,l.code as key, l.value as description from ContactUs pto, Label l  join pto.attribute a  where l.code= pto.value";
    private static final String DELIMITTER = "###";
    @Override
    public ContactUsDTO getContactUsEmailWidgets(String program) {
            Query query =sessionFactory.getCurrentSession().createQuery(HQLWIDGETS);
            List<Object[]> rows = query.list();
            ContactUsDTO queryResult = new ContactUsDTO();
            Map<String,String> header = new HashMap<String,String>(6);
            Map<String,String> comments = new HashMap<String,String>(2);
            Map<String,Object> questions = new HashMap<String,Object>(2);
            for(Object[] rowNested:rows){
                if(Constants.CONTACTUS_HEADER_PREFIX.equalsIgnoreCase((String)rowNested[0])){
                    header.put(((String)rowNested[1]).replace(Constants.CONTACTUS_HEADER_PREFIX+"_", "").toLowerCase(), (String)rowNested[2]);
                }else if(Constants.CONTACTUS_COMMENTS_PREFIX.equalsIgnoreCase((String)rowNested[0])){
                    comments.put(((String)rowNested[1]).replace(Constants.CONTACTUS_COMMENTS_PREFIX+"_", "").toLowerCase(), (String)rowNested[2]);
                }else if(Constants.CONTACTUS_QUESTIONS_PREFIX.equalsIgnoreCase((String)rowNested[0])){
                    questions.put(((String)rowNested[1]).replace(Constants.CONTACTUS_QUESTIONS_PREFIX+"_", "").toLowerCase(),((String)rowNested[2]).contains(DELIMITTER)?((String)rowNested[2]).split(DELIMITTER):(String)rowNested[2]);
                }
            }
            queryResult.setComments(comments);
            queryResult.setHeader(header);
            queryResult.setQuestions(questions);
            return queryResult; 
    }

    @Override
    protected Class<ContactUs> getDataClass() {
        return ContactUs.class;
    }


}
