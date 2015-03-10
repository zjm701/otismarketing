package com.otis.marketing.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {

	public T get(Class<T> entityClass, Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	public void save(T o) {
		this.getHibernateTemplate().save(o);
	}

	public void delete(T o) {
		this.getHibernateTemplate().delete(o);
	}

	public void update(T o) {
		this.getHibernateTemplate().update(o);
	}

	public List<T> find(String hql, Object... values) {
		return (List<T>) this.getHibernateTemplate().find(hql, values);
	}

	public int execute(String hql, Object... values) {
		return this.getHibernateTemplate().bulkUpdate(hql, values);
	}
}