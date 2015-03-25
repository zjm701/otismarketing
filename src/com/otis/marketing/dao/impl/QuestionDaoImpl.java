package com.otis.marketing.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.otis.marketing.dao.QuestionDao;
import com.otis.marketing.entity.Question;

public class QuestionDaoImpl extends BaseDao<Question> implements QuestionDao {

	private static Logger logger = Logger.getLogger(QuestionDaoImpl.class);
	
//	@Override
//	public Question getQuestionById(Integer questionId){
//		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class).add(Restrictions.idEq(questionId));
//		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
//		return (Question)findByCriteria.get(0);
//	}
	
	public Question get(int id) throws DataAccessException {
		return super.get(Question.class, id);
	}
	
//	@Override
//	public List<Option> getOptionsByQuestionId(Integer questionId) {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class).add(Restrictions.idEq(questionId));
//		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
//		List<Question> questions = findByCriteria;
//		Question question = null;
//		if (questions != null) {
//			Iterator it = questions.iterator();
//			while (it.hasNext()) {
//				question = (Question)it.next();
//			}
//		}
//		if (question != null) {
//			return splitOptionString(question.getOptionsString());
//		} else {
//			//TODO Exception
//			return null;
//		}
//	}

}
