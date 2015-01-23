package com.erecyclingcorps.dao.domain;

// Generated 24 Nov, 2014 10:40:04 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RefLocaleAttribute generated by hbm2java
 */
@Entity
@Table(name = "ref_locale_attribute", schema = "public")
public class LocaleAttribute implements java.io.Serializable {

	private long localeattributeid;
	private Attribute refAttribute;
	private Locale refLocale;
	private String value;

	public LocaleAttribute() {
	}

	public LocaleAttribute(long localeattributeid,
			Attribute refAttribute, Locale refLocale, String value) {
		this.localeattributeid = localeattributeid;
		this.refAttribute = refAttribute;
		this.refLocale = refLocale;
		this.value = value;
	}

	@Id
	@Column(name = "localeattributeid", unique = true, nullable = false)
	public long getLocaleattributeid() {
		return this.localeattributeid;
	}

	public void setLocaleattributeid(long localeattributeid) {
		this.localeattributeid = localeattributeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "attributeid", nullable = false)
	public Attribute getRefAttribute() {
		return this.refAttribute;
	}

	public void setRefAttribute(Attribute refAttribute) {
		this.refAttribute = refAttribute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localeid", nullable = false)
	public Locale getRefLocale() {
		return this.refLocale;
	}

	public void setRefLocale(Locale refLocale) {
		this.refLocale = refLocale;
	}

	@Column(name = "value", nullable = false)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}