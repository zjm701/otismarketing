package com.otis.marketing.dao.impl;

import org.hibernate.Session;

import com.otis.marketing.dao.ReplyDao;
import com.otis.marketing.entity.Reply;
import com.otis.marketing.entity.Survey;

public class ReplyDaoImpl extends BaseDao<Reply> implements ReplyDao {

	public void save(Reply reply) {
		this.getHibernateTemplate().save(reply);
	}
}
