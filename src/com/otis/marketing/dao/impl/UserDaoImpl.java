package com.otis.marketing.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Question;
import com.otis.marketing.entity.Role;
import com.otis.marketing.entity.Users;

@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public Users findByName(String userName) throws DataAccessException {

		List objs = this.getHibernateTemplate().find(
				"from Users where username=? and enabled=1", userName);
		List<Users> users = objs;

		return (users.size() == 0 ? null : users.get(0));
	}

	public void saveUser(Users user) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(user);
	}
	
	public Role findRoleByName(String roleName) throws DataAccessException {
		return (Role)this.getHibernateTemplate().find("from Role where name='"+ roleName +"'").get(0);
	}

	public List<Users> findAllUser() throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
		criteria.add(Restrictions.ne("username", "admin"));
		criteria.add(Restrictions.eq("enabled", 1));
		criteria.addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("rawtypes")
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		List<Users> users = findByCriteria;
		
		return users;
	}

	@Override
	public void changePassWord(String newPassWord, Integer userId)
			throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
		criteria.add(Restrictions.eq("id", userId));
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		
		List<Users> users = findByCriteria;
		Users user = (Users)users.get(0);
		user.setPassword(newPassWord);
		getHibernateTemplate().update(user);
	}

	@Override
	public void updateUser(Users user) throws DataAccessException {
		this.getHibernateTemplate().update(user);
		
	}

	@Override
	public Users findById(Integer userId) throws DataAccessException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class).add(Restrictions.idEq(userId));
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		return (Users)findByCriteria.get(0);
	}
}
