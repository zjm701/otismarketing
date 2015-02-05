package com.otis.marketing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.NewsDao;
import com.otis.marketing.entity.News;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	public void saveUser(News news) throws DataAccessException {
		this.getHibernateTemplate().save(news);
	}

	@Override
	public List<News> findAllNews() throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		criteria.addOrder(Order.asc("id"));
		
		@SuppressWarnings("rawtypes")
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		List<News> newsList = findByCriteria;
		
		return newsList;
	}

}
