package com.otis.marketing.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "tbl_role")
public class Role implements Serializable {

	private static final long serialVersionUID = -3575119623880957623L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "descr", length = 50)
	private String descr;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "createtime")
//	private Date createDate;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "updatetime")
//	private Date updateDate;
//
//	@Column(name = "enabled")
//	private Integer enabled;

	@ManyToMany(mappedBy = "roles")
	private Set<Users> users = new HashSet<Users>();

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_role_resource", joinColumns = { @JoinColumn(name = "roleid") }, inverseJoinColumns = { @JoinColumn(name = "resourceid") })
	private Set<Resources> resources = new HashSet<Resources>();

	public Role() {

	}

	public Role(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	public Integer getEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(Integer enabled) {
//		this.enabled = enabled;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Resources> getResources() {
		return resources;
	}

	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}

}
