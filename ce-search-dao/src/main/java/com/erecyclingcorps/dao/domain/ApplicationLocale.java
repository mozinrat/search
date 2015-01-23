package com.erecyclingcorps.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author parora
 * 
 * Generated 24 Nov, 2014 10:40:04 AM  
 **/

@Entity
@Table(name = "ref_application_locale", schema = "public")
public class ApplicationLocale implements java.io.Serializable {

	@Id
	@Column(name = "applocaleid", unique = true, nullable = false)
	private long applocaleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationid", nullable = false)
	private Application application;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localeid", nullable = false)
	private Locale locale;

	public long getApplocaleId() {
		return applocaleId;
	}

	public void setApplocaleId(long applocaleId) {
		this.applocaleId = applocaleId;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
