package com.erecyclingcorps.dao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ref_label", schema = "public")
public class Label implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6870480246363151202L;

    @Id
    @Column(name = "labelid", unique = true, nullable = false)
    private long labelid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applocaleid")
    private ApplicationLocale applicationLocale;
    
    @Column(name = "value", nullable = false)
    private String value;
    
    @Column(name = "updatedby")
    private Long updatedby;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateddate", length = 35)
    private Date updateddate;

    @Column(name = "createdby", nullable = false)
    private long createdby;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate", nullable = false, length = 35)
    private Date createddate;
    
    @Column(name = "code")
    private String code;

    
    public long getLabelid() {
        return this.labelid;
    }

    public void setLabelid(long labelid) {
        this.labelid = labelid;
    }

    
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    public Long getUpdatedby() {
        return this.updatedby;
    }

    public void setUpdatedby(Long updatedby) {
        this.updatedby = updatedby;
    }

    
    public Date getUpdateddate() {
        return this.updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    
    public long getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(long createdby) {
        this.createdby = createdby;
    }

 
    public Date getCreateddate() {
        return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }


    public ApplicationLocale getApplicationLocale() {
        return applicationLocale;
    }

    public void setApplicationLocale(ApplicationLocale applicationLocale) {
        this.applicationLocale = applicationLocale;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
