package com.erecyclingcorps.dao.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * @author parora
 **/
@Entity
@Table(name = "ref_manufacturermodel", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "modelcode"))
public class ManufacturerModel implements java.io.Serializable {

	@Id
	@Column(name = "manufacturermodelid", unique = true, nullable = false)
	private long manufacturerModelId;

	@Version
	@Column(name = "version", nullable = false)
	private int version;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturerid", nullable = false)
	private Manufacturer manufacturer;

	@Column(name = "modelnumber", nullable = false)
	private String modelNumber;

	@Column(name = "modelcode", unique = true)
	private String modelCode;

	@Column(name = "description", nullable = false)
	private long description;

	@Column(name = "noimage", nullable = false)
	private boolean noImage;

	@Column(name = "imageurl")
	private String imageUrl;

	@Column(name = "imageversion", nullable = false)
	private int imageVersion;

	@Column(name = "product", nullable = false)
	private String product;

	@Column(name = "generation", nullable = false)
	private String generation;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdby", nullable = false)
	private User createdy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = false)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastupdateddate")
	private Date lastupdateddate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updatedby")
	private User updatedBy;

	@Column(name = "weight")
	private String weight;

	@Column(name = "fcccode")
	private String fccCode;

	@Column(name = "active", nullable = false)
	private boolean active;

	@Column(name = "batterytype", nullable = false)
	private String batteryType;

	@Column(name = "adjustmentremindertext")
	private String adjustmentReminderText;

	@Column(name = "identification_number")
	private Long identificationNumber;

	@Column(name = "colors")
	private String colors;

	@Column(name = "operatingsystem", length = 1000)
	private String operatingSystem;

	@Column(name = "operatingsystemversion", length = 1000)
	private String operatingSystemVersion;

	@Column(name = "capacity", length = 1000)
	private String capacity;

	@Column(name = "productclass", length = 1000)
	private String productclass;

	@Column(name = "productfamily", length = 1000)
	private String productfamily;

	@Column(name = "lteenabled")
	private Boolean lteEnabled;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturerModel")
	private Set<ProgramManufacturerModel> programManufacturerModels = new HashSet<ProgramManufacturerModel>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturerModel")
	private Set<ModelAttachment> modelAttachments = new HashSet<ModelAttachment>();

	public long getManufacturerModelId() {
		return manufacturerModelId;
	}

	public void setManufacturerModelId(long manufacturerModelId) {
		this.manufacturerModelId = manufacturerModelId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public long getDescription() {
		return description;
	}

	public void setDescription(long description) {
		this.description = description;
	}

	public boolean isNoImage() {
		return noImage;
	}

	public void setNoImage(boolean noImage) {
		this.noImage = noImage;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getImageVersion() {
		return imageVersion;
	}

	public void setImageVersion(int imageVersion) {
		this.imageVersion = imageVersion;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public User getCreatedy() {
		return createdy;
	}

	public void setCreatedy(User createdy) {
		this.createdy = createdy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getFccCode() {
		return fccCode;
	}

	public void setFccCode(String fccCode) {
		this.fccCode = fccCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public String getAdjustmentReminderText() {
		return adjustmentReminderText;
	}

	public void setAdjustmentReminderText(String adjustmentReminderText) {
		this.adjustmentReminderText = adjustmentReminderText;
	}

	public Long getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(Long identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getProductclass() {
		return productclass;
	}

	public void setProductclass(String productclass) {
		this.productclass = productclass;
	}

	public String getProductfamily() {
		return productfamily;
	}

	public void setProductfamily(String productfamily) {
		this.productfamily = productfamily;
	}

	public Boolean getLteEnabled() {
		return lteEnabled;
	}

	public void setLteEnabled(Boolean lteEnabled) {
		this.lteEnabled = lteEnabled;
	}

	public Set<ProgramManufacturerModel> getProgramManufacturerModels() {
		return programManufacturerModels;
	}

	public void setProgramManufacturerModels(
			Set<ProgramManufacturerModel> programManufacturerModels) {
		this.programManufacturerModels = programManufacturerModels;
	}

	public Set<ModelAttachment> getModelAttachments() {
		return modelAttachments;
	}

	public void setModelAttachments(Set<ModelAttachment> modelAttachments) {
		this.modelAttachments = modelAttachments;
	}

}
