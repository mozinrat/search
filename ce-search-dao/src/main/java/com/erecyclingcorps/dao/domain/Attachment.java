package com.erecyclingcorps.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author parora
 **/

@Entity
@Table(name = "fs_attachment")
public class Attachment {

	@Id
	@Column(name="attachmentid")
	private Long id = new Long(-1);

	@Version
	@Column(name="version")
	private Integer version;

	@Column(name="attachment")
	private byte[] attachment;

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

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
}
