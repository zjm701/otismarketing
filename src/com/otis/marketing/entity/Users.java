package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_user")
public class Users implements Serializable, UserDetails {

	private static final long serialVersionUID = -2421014524781718601L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", length = 20)
	private String username;

	@Column(name = "password", length = 20)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createtime")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatetime")
	private Date updateDate;

	@Column(name = "enabled")
	private Integer enabled;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "roleid") })
	private Set<Role> roles = new HashSet<Role>();

	@Transient
	private Collection<GrantedAuthority> authorities;
	
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		if(authorities!=null){
			return authorities;
		}else{
			if(roles==null || roles.size()==0){
				return null;
			}else{
				authorities = new ArrayList<GrantedAuthority>(roles.size());
				for (Role role : roles) {
					authorities.add(new SimpleGrantedAuthority(role.getName()));
				}
				return authorities;
			}
		}
	}
	
	@Transient
	public void clearAuthorities() {
		authorities=null;
	}
	
	public Users() {
	}
	
	public Users(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
