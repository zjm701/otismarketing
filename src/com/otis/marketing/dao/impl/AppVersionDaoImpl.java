package com.otis.marketing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.AppVersionDao;
import com.otis.marketing.entity.AppVersion;

public class AppVersionDaoImpl extends HibernateDaoSupport implements
		AppVersionDao {

	@Override
	public void saveAppVersion(AppVersion appVersion) throws DataAccessException {
		this.getHibernateTemplate().save(appVersion);
	}

	@Override
	public void updateAppVersion(AppVersion appVersion) throws DataAccessException {
		this.getHibernateTemplate().update(appVersion);
	}

	@Override
	public void deleteAppVersion(AppVersion appVersion) throws DataAccessException {
		this.getHibernateTemplate().delete(appVersion);
	}

	@Override
	public List<AppVersion> findAllAppVersion() throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(AppVersion.class);
		criteria.addOrder(Order.asc("id"));

		@SuppressWarnings("rawtypes")
		List findByCriteria = this.getHibernateTemplate().findByCriteria(
				criteria);
		List<AppVersion> versionList = findByCriteria;

		return versionList;
	}

	@Override
	public AppVersion findAppVersionById(Integer versionId) throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(AppVersion.class);
		criteria.add(Restrictions.eq("id", versionId));
		
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		List<AppVersion> versionsList = findByCriteria;
		
		AppVersion version = null;
		if(versionsList != null && !versionsList.isEmpty()){
			version = versionsList.get(0);
		}

		return version;
	}
}
