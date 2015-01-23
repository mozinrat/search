package com.erecyclingcorps.dao.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.erecyclingcorps.dto.UserDTO;

/**
 * @author parora
 **/

@NamedQueries({
		@NamedQuery(name = "getUserWithRole", query = "from User as user join fetch user.authority where user.username=:username") })
@Entity
@Table(name = "fs_user")
public class User implements UserDetails,UserDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1759752022681703533L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid", unique = true, nullable = false)
	private long userId;
	
	@Column(name = "version", nullable = false)
	private long version;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "createdby")
	private User createdBy;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "updatedby")
	private User updatedBy;
	
	@Column(name = "createddate", nullable = false)
	private Date createdDate;
	
	@Column(name = "lastupdateddate", nullable = false)
	private Date lastUpdatedDate;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "lastchangedpassworddate")
	private Date lastChangedPasswordDate;
	
	@Column(name = "showpreferences")
	private Boolean showPreferences;
	
	@Column(name = "timezone")
	private String timeZone;
	
	@ManyToOne
	@JoinColumn(name="applicationid")
	private Application application;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "fs_user_role", joinColumns = { @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false, insertable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "roleid", referencedColumnName = "roleid", insertable = false, updatable = false, nullable = false) })
	private Set<Role> authority = new HashSet<Role>();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contactid")
	private Contact contact;

	private transient Collection<GrantedAuthority> authorities;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Role> authority) {
		this.authority = authority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getShowPreferences() {
		return showPreferences;
	}

	public void setShowPreferences(Boolean showPreferences) {
		this.showPreferences = showPreferences;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (!authority.isEmpty() && authorities == null) {
			List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
			for (Role role : authority) {
				listOfAuthorities.add(new SimpleGrantedAuthority(role
						.getRoleType()));
			}
			this.authorities = listOfAuthorities;
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getLastChangedPasswordDate() {
		return lastChangedPasswordDate;
	}

	public void setLastChangedPasswordDate(Date lastChangedPasswordDate) {
		this.lastChangedPasswordDate = lastChangedPasswordDate;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
