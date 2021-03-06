//package com.erecyclingcorps.dao.domain;
//
//// Generated 24 Nov, 2014 10:40:04 AM by Hibernate Tools 4.3.1
//
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
///**
// * RefCarrier generated by hbm2java
// */
//@Entity
//@Table(name = "ref_carrier", schema = "public")
//public class Carrier implements java.io.Serializable {
//
//	private long carrierid;
//	private RefProgram refProgram;
//	private String code;
//	private String description;
//	private int sortorder;
//	private long createdby;
//	private Date createddate;
//	private Date updateddate;
//	private Long updatedby;
//
//	public Carrier() {
//	}
//
//	public Carrier(long carrierid, RefProgram refProgram, String code,
//			String description, int sortorder, long createdby, Date createddate) {
//		this.carrierid = carrierid;
//		this.refProgram = refProgram;
//		this.code = code;
//		this.description = description;
//		this.sortorder = sortorder;
//		this.createdby = createdby;
//		this.createddate = createddate;
//	}
//
//	public Carrier(long carrierid, RefProgram refProgram, String code,
//			String description, int sortorder, long createdby,
//			Date createddate, Date updateddate, Long updatedby) {
//		this.carrierid = carrierid;
//		this.refProgram = refProgram;
//		this.code = code;
//		this.description = description;
//		this.sortorder = sortorder;
//		this.createdby = createdby;
//		this.createddate = createddate;
//		this.updateddate = updateddate;
//		this.updatedby = updatedby;
//	}
//
//	@Id
//	@Column(name = "carrierid", unique = true, nullable = false)
//	public long getCarrierid() {
//		return this.carrierid;
//	}
//
//	public void setCarrierid(long carrierid) {
//		this.carrierid = carrierid;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "programid", nullable = false)
//	public RefProgram getRefProgram() {
//		return this.refProgram;
//	}
//
//	public void setRefProgram(RefProgram refProgram) {
//		this.refProgram = refProgram;
//	}
//
//	@Column(name = "code", nullable = false)
//	public String getCode() {
//		return this.code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	@Column(name = "description", nullable = false, length = 1000)
//	public String getDescription() {
//		return this.description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	@Column(name = "sortorder", nullable = false)
//	public int getSortorder() {
//		return this.sortorder;
//	}
//
//	public void setSortorder(int sortorder) {
//		this.sortorder = sortorder;
//	}
//
//	@Column(name = "createdby", nullable = false)
//	public long getCreatedby() {
//		return this.createdby;
//	}
//
//	public void setCreatedby(long createdby) {
//		this.createdby = createdby;
//	}
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "createddate", nullable = false, length = 35)
//	public Date getCreateddate() {
//		return this.createddate;
//	}
//
//	public void setCreateddate(Date createddate) {
//		this.createddate = createddate;
//	}
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "updateddate", length = 35)
//	public Date getUpdateddate() {
//		return this.updateddate;
//	}
//
//	public void setUpdateddate(Date updateddate) {
//		this.updateddate = updateddate;
//	}
//
//	@Column(name = "updatedby")
//	public Long getUpdatedby() {
//		return this.updatedby;
//	}
//
//	public void setUpdatedby(Long updatedby) {
//		this.updatedby = updatedby;
//	}
//
//}
