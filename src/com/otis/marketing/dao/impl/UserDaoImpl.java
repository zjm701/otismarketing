package com.otis.marketing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Role;
import com.otis.marketing.entity.Users;

@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public Users findByName(String userName) throws DataAccessException {

		List objs = this.getHibernateTemplate().find(
				"from Users where username=?", userName);
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
		criteria.addOrder(Order.asc("id"));
		
		@SuppressWarnings("rawtypes")
		List findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		List<Users> users = findByCriteria;
		
		return users;
	}
	
}
