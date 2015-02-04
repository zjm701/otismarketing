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

}
