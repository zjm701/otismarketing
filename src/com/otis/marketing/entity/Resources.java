package com.otis.marketing.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Entity
@Table(name = "tbl_resource")
public class Resources implements Serializable {

	private static final long serialVersionUID = 1992478647424564545L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "descr", length = 50)
	private String descr;

	@Column(name = "url", length = 50)
	private String url;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_role_resource", joinColumns = { @JoinColumn(name = "resourceid") }, inverseJoinColumns = { @JoinColumn(name = "roleid") })
	private Set<Role> roles = new HashSet<Role>();

	@Transient
	private Collection<ConfigAttribute> configAttributes;
	@Transient
	private RequestMatcher urlMatcher;
	
	@Transient
	public Collection<ConfigAttribute> getConfigAttributes() {
		if(configAttributes!=null){
			return configAttributes;
		}else{
			if(roles==null || roles.size()==0){
				return null;
			}else{
				configAttributes = new ArrayList<ConfigAttribute>(roles.size());
				for (Role role : roles) {
					configAttributes.add(new SecurityConfig(role.getName().trim()));
				}
				return configAttributes;
			}
		}
	}
	@Transient
	public boolean matches(HttpServletRequest request){
		if(urlMatcher==null){
			urlMatcher = new AntPathRequestMatcher(url);
		}
		return urlMatcher.matches(request);
	}
	
	@Transient
	public void clearConfigAttributes() {
		configAttributes=null;
	}
	
	@Transient
	public void clearUrlMatcher() {
		urlMatcher=null;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
