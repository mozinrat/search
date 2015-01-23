package com.erecyclingcorps.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.erecyclingcorps.dto.AttachmentType;

/**
 * @author parora
 **/

@Entity
@Table(name = "ref_modelattachment")
public class ModelAttachment {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "modelattachmentid")
	private Long id = new Long(-1);

	@Version
	@Column(name = "version", nullable = false)
	private Integer version;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturermodelid")
	private ManufacturerModel manufacturerModel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "attachmentid")
	private Attachment attachment;

	@Enumerated(EnumType.STRING)
	@Column(name = "attachmenttype")
	private AttachmentType attachmentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public ManufacturerModel getManufacturerModel() {
		return manufacturerModel;
	}

	public void setManufacturerModel(ManufacturerModel manufacturerModel) {
		this.manufacturerModel = manufacturerModel;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public AttachmentType getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(AttachmentType attachmentType) {
		this.attachmentType = attachmentType;
	}

}
