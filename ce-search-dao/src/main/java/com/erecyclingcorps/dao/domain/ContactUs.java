package com.erecyclingcorps.dao.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * RefProgramGenAttribute generated by hbm2java
 */
@Entity
@Table(name = "ref_program_gen_attribute")
@DiscriminatorValue(value="CONTACTUS")
public class ContactUs extends ProgramGenAttribute implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4303239054400507028L;

}