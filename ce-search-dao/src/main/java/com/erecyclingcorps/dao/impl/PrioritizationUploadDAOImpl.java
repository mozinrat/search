package com.erecyclingcorps.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.PrioritizationUploadDAO;
import com.erecyclingcorps.dao.domain.PrioritizationType;
import com.erecyclingcorps.dao.domain.PrioritizationUpload;

@Repository
public class PrioritizationUploadDAOImpl extends BaseDAOImpl<PrioritizationUpload, Serializable> implements PrioritizationUploadDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    protected Class<PrioritizationUpload> getDataClass() {
        return PrioritizationUpload.class;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public byte[] getFile(PrioritizationType prioritizationType) {
        PrioritizationUpload prioritizationUpload =
                (PrioritizationUpload) getCurrentSession().createCriteria(PrioritizationUpload.class).createAlias("prioritizationType", "pt")
                .add(Restrictions.eq("pt.id", prioritizationType.getId())).uniqueResult();
        if (prioritizationUpload != null){
            return prioritizationUpload.getFileByteArray();
        } else {
            // return empty array instead of null
            return new byte[]{}; 
        }
    }

    @Override
    public void deleteByPrioritizationType(PrioritizationType prioritizationType) {
        PrioritizationUpload prioritizationUpload =
                (PrioritizationUpload) getCurrentSession().createQuery("from PrioritizationUpload where prioritizationType.id=:ptid")
                .setParameter("ptid", prioritizationType.getId()).uniqueResult();
        if (prioritizationUpload != null) {
            delete(prioritizationUpload.getId());
        }
    }
}
