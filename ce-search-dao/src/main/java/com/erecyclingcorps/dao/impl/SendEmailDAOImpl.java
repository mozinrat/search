package com.erecyclingcorps.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.ProgramDAO;
import com.erecyclingcorps.dao.SendEmailDAO;
import com.erecyclingcorps.dao.domain.Email;
import com.erecyclingcorps.dao.domain.Program;
import com.erecyclingcorps.dto.EmailDetailDTO;

/**
 * @author rverma
 *
 */
@Repository("sendEmailDAO")
public class SendEmailDAOImpl extends BaseDAOImpl<Email, Serializable> implements SendEmailDAO {

    private static final int MAX_RETRY_COUNT=3;
    private static final String ATTR_PROGRAM = "program";
    private static final String ATTR_RETRY_COUNT = "retrycount";
    private static final String ATTR_EMAIL_ID = "id";
    private static final String RETRY_EMAIL_QUERY = "getRetryEmails";
    private static final String GET_EMAIL_QUERY = "getEmailbyId";

    @Autowired
    ProgramDAO programDAO;

    @Override
    protected Class<Email> getDataClass() {
        return Email.class;
    }

    @Override
    public void persistEmail(EmailDetailDTO emailcontent,String status) {
        Program program = programDAO.findProgramByCode(emailcontent.getProgram());
        Email email = new Email(emailcontent.getSubject(),emailcontent.getMessage(),emailcontent.getSenderAddress(),emailcontent.getRecipientAddress(),new Date(),status,program);
        super.save(email);
    }

    @Override
    public void persistRetriedEmail(EmailDetailDTO emailContent,String status) {
        Email email =  (Email)sessionFactory.getCurrentSession().getNamedQuery(GET_EMAIL_QUERY)
                .setLong(ATTR_EMAIL_ID, emailContent.getId()).uniqueResult();
        email.setRetrydate(new Date());
        email.setStatus(status);
        super.update(email);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<EmailDetailDTO> getRetryEmails(String program) {
        Query query =sessionFactory.getCurrentSession().getNamedQuery(RETRY_EMAIL_QUERY);
        query.setLong(ATTR_PROGRAM,programDAO.findByCode(program));
        query.setLong(ATTR_RETRY_COUNT,MAX_RETRY_COUNT);
        return query.setResultTransformer(Transformers .aliasToBean(EmailDetailDTO.class)).list();
    }
}

