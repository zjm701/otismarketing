package com.otis.marketing.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.StatisticDao;

public class StatisticDaoImpl extends HibernateDaoSupport implements StatisticDao {

	@Override
	public Object getSurveyStatistic(Long surveyId) {
		List list = this.getHibernateTemplate().find("select a.intValue, sum(1) as sum from Answer a where a.question.id=1 group by a.intValue");
		return null;
	}
	
	

}
