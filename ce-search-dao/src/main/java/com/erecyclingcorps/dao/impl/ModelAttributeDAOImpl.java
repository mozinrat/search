package com.erecyclingcorps.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.ModelAttributeDAO;
import com.erecyclingcorps.dao.ProgramCategoryDAO;
import com.erecyclingcorps.dao.domain.HstoreHelper;
import com.erecyclingcorps.dao.domain.SearchAttributes;
import com.erecyclingcorps.dto.ModelAttributeDTO;
import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.exceptions.FilterNotFoundException;

/**
 * @author rverma
 *
 */
@Repository("modelAttributeDAO")
public class ModelAttributeDAOImpl extends BaseDAOImpl<SearchAttributes,Long> implements ModelAttributeDAO {

    @Autowired
    ProgramCategoryDAO programCategoryDAO;

    @Autowired
    HstoreHelper hstoreHelper;

    private static final String PARAMETER_PROGRAM= "program";
    private static final String CATEGORYCODE= "CELLPHONE";
    private static final String FILTERNOTFOUND_SQL_STATE="50001";
    private static final String HQL_WIDGETS = "select a.name as code, sa.label as label, sa.helpText as helptext,sa.tigger as tigger from SearchAttributes sa "
            + "join sa.attribute a where sa.programCategory.id = :"+PARAMETER_PROGRAM+" AND sa.isactive='true' order by sa.displayOrder" ;

    @Override
    protected Class<SearchAttributes> getDataClass() {
        return SearchAttributes.class;
    }

    @Override
    public List<ModelAttributeDTO> getSearchWidgets(String program) {
        Query query =sessionFactory.getCurrentSession().createQuery(HQL_WIDGETS);
        query.setLong(PARAMETER_PROGRAM,programCategoryDAO.getIdbyProgram(program,CATEGORYCODE));
        List<ModelAttributeDTO> rowsNested = query.setResultTransformer(Transformers .aliasToBean(ModelAttributeDTO.class)).list();
        return rowsNested;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<String> getSearchWidgetValues(ModelAttributeSearchDTO searchDTO) throws FilterNotFoundException {
        String filter = (searchDTO.getFilters().isEmpty())?"null":hstoreHelper.toString(searchDTO.getFilters());
        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT show_feature_search_attributes(:programcategoryid,:resourcetype,"+filter+")")
                .setInteger("programcategoryid", programCategoryDAO.getIdbyProgram(searchDTO.getProgram(), CATEGORYCODE).intValue()).
                setParameter("resourcetype",searchDTO.getResourcetype().toString());
        List<String> result = new ArrayList<String>(1) ;
        try{
            result =  query.list();
        }catch(GenericJDBCException ex){
            if(FILTERNOTFOUND_SQL_STATE.equalsIgnoreCase(ex.getSQLState())) {
                throw new FilterNotFoundException();
            } else {
                throw ex;
            }
        }
        return result;
    }

}


