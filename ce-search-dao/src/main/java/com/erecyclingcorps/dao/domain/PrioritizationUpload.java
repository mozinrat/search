package com.erecyclingcorps.dao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * 
 * @author bbansal
 *
 */
/**
 * @author bbansal
 *
 */
@Entity
@Table(name = "ref_prioritization_upload")
@SQLDelete(sql = "UPDATE ref_prioritization_upload SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted != 1")
public class PrioritizationUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "updatedfile")
	private byte[] fileByteArray;
	@Column(name = "uploadedtime")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date uploadedtime;
	@ManyToOne
	@JoinColumn(name = "prioritizationtypeid")
	private PrioritizationType prioritizationType;
	@Column(name = "uploadedby")
	private String uploadedby;
	@Column(name = "status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getFileByteArray() {
		return fileByteArray;
	}

	public void setFileByteArray(byte[] fileByteArray) {
		this.fileByteArray = fileByteArray;
	}

	public Date getUploadedtime() {
		return uploadedtime;
	}

	public void setUploadedtime(Date uploadedtime) {
		this.uploadedtime = uploadedtime;
	}

	public String getUploadedby() {
		return uploadedby;
	}

	public void setUploadedby(String uploadedby) {
		this.uploadedby = uploadedby;
	}

	public PrioritizationType getPrioritizationType() {
		return prioritizationType;
	}

	public void setPrioritizationType(PrioritizationType prioritizationType) {
		this.prioritizationType = prioritizationType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
