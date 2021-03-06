package com.erecyclingcorps.dao.domain;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * RefProgramGenAttribute generated by hbm2java
 */

@NamedQueries({ @NamedQuery(name = "getProgramTradeOptions", query = "select l.code as code, l.value as label, pto.sortOrder as sortOrder, pto.isMandatory as mandatory,pto.isHidden as hidden,"
		+ "pto.attribute.name as type from ProgramTradeOptions pto, Label l  join pto.attribute a  where l.code= pto.value order by pto.attribute.name,pto.sortOrder") })

@Entity
@Table(name = "ref_program_gen_attribute")
@DiscriminatorValue(value="TRADE_OPTIONS")
public class ProgramTradeOptions extends ProgramGenAttribute implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "sortorder")
    private Long sortOrder;

    @Column(name = "ismandatory")
    private Boolean isMandatory;
    
    @Column(name = "ishidden")
    private Boolean isHidden;

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }
    
}