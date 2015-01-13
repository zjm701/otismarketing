package com.otis.marketing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.ResourceDao;
import com.otis.marketing.entity.Resources;

public class ResourceDaoImpl extends HibernateDaoSupport implements
		ResourceDao {

	@Override
	public List<Resources> findAll() throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Resources.class);
		return (List<Resources>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	// @Override
	// public List<Resources> findAll() {
	// List<Resources> resources = new ArrayList<Resources>();
	//
	// Resources r1 = new Resources();
	// r1.setName("userAdminUrl");
	// r1.setUrl("adminPage");
	//
	// Resources r2 = new Resources();
	// r2.setName("userUrl");
	// r2.setUrl("userPage");
	//
	// Role adminRole = new Role();
	// adminRole.setId(1);
	// adminRole.setName("ROLE_ADMIN");
	//
	// Role userRole = new Role();
	// userRole.setId(2);
	// userRole.setName("ROLE_USER");
	//
	// HashSet<Role> roles_adminURL = new HashSet<Role>();
	// roles_adminURL.add(adminRole);
	//
	// HashSet<Role> roles_userURL = new HashSet<Role>();
	// roles_userURL.add(adminRole);
	// roles_userURL.add(userRole);
	//
	// r1.setRoles(roles_adminURL);
	// r2.setRoles(roles_userURL);
	//
	// resources.add(r1);
	// resources.add(r2);
	//
	// return resources;
	// }

}
