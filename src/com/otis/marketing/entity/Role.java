package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Role implements Serializable {

	private static final long serialVersionUID = -3575119623880957623L;

	private Integer id;

	private String name;

	private String descr;

	private Date createDate;

	private Date updateDate;

	private Integer enabled;

	private Set<Integer> users;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Set<Integer> getUsers() {
		return users;
	}

	public void setUsers(Set<Integer> users) {
		this.users = users;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
