package com.otis.marketing.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.StatisticDao;
import com.otis.marketing.entity.Option;
import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Statistic;
import com.otis.marketing.entity.StatisticItem;
import com.otis.marketing.entity.Survey;

public class StatisticDaoImpl extends HibernateDaoSupport implements StatisticDao {

	private static Logger logger = Logger.getLogger(StatisticDaoImpl.class);
	
	@Override
	public Statistic getSurveyStatistic(Integer surveyId) {
		Statistic statistic = new Statistic();
		DetachedCriteria criteria = DetachedCriteria.forClass(Survey.class).add(Restrictions.idEq(surveyId));
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		if (findByCriteria != null && !findByCriteria.isEmpty()){
			Survey survey = (Survey)findByCriteria.get(0);
			statistic.setTitle(survey.getTitle());
			List<Question> questions = survey.getQuestions();
			for (Question question : questions) {
				Map<Integer, Option> options = question.splitOptionString();
				List list = this.getHibernateTemplate().find("select a.intValue, sum(1) as sum from Answer a where a.question.id=? group by a.intValue", question.getQuestionId());
				for (Integer key : options.keySet()){
					StatisticItem item = new StatisticItem();
					item.setOptionDesc(options.get(key).getDescription());
					
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i ++) {
							if (key == (Integer)((Object[])list.get(i))[0]) {
								item.setTotal((Long)((Object[])list.get(i))[1]);
							} else {
								continue;
							}
						}
					}
					statistic.addItem(item);
				}
			}
		}
		return statistic;
	}
	
	

}
