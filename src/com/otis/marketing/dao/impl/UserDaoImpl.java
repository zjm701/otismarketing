package com.otis.marketing.dao.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Users;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public Users findByName(String userName) throws DataAccessException {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
//		criteria.add(Restrictions.eq("username", userName));
//		criteria.setFetchMode("roles.resources", FetchMode.JOIN);
//
//		List findByCriteria = this.getHibernateTemplate().findByCriteria(
//				criteria);
//		List<Users> users = findByCriteria;
//		Users user = null;
//		if (users != null && !users.isEmpty()) {
//			user = (Users) users.get(0);
//		}
//		return user;
		
		List objs = this.getHibernateTemplate().find("from Users where username=?", userName);
		List<Users> users = objs;
		
		return (users.size() == 0 ? null : users.get(0)); 
	}

	// @Override
	// public Users findByName(String userName) {
	// Users user = new Users();
	// user.setEnabled(1);
	// user.setName(userName);
	// if ("admin".equals(userName)) {
	// user.setId(1);
	// user.setPassword("admin");
	//
	// Role adminRole = new Role();
	// adminRole.setId(1);
	// adminRole.setName("ROLE_ADMIN");
	//
	// Role userRole = new Role();
	// userRole.setId(2);
	// userRole.setName("ROLE_USER");
	//
	// Resources r1 = new Resources();
	// r1.setName("userAdminUrl");
	// //r1.setUrl("adminPage");
	// r1.setUrl("/jsps/index.jsp");
	//
	// Resources r2 = new Resources();
	// r2.setName("userUrl");
	// r2.setUrl("userPage");
	//
	// HashSet<Resources> admin_res = new HashSet<Resources>();
	// admin_res.add(r1);
	// admin_res.add(r2);
	//
	// HashSet<Resources> user_res = new HashSet<Resources>();
	// user_res.add(r2);
	//
	// adminRole.setResources(admin_res);
	// userRole.setResources(user_res);
	//
	// HashSet<Role> roles_admin = new HashSet<Role>();
	// roles_admin.add(adminRole);
	// roles_admin.add(userRole);
	//
	// user.setRoles(roles_admin);
	// }
	// if ("user".equals(userName)) {
	// user.setId(2);
	// user.setPassword("user");
	//
	// Role userRole = new Role();
	// userRole.setId(2);
	// userRole.setName("ROLE_USER");
	//
	// Resources r2 = new Resources();
	// r2.setName("userUrl");
	// r2.setUrl("userPage");
	//
	// HashSet<Resources> user_res = new HashSet<Resources>();
	// user_res.add(r2);
	//
	// userRole.setResources(user_res);
	//
	// HashSet<Role> roles_user = new HashSet<Role>();
	// roles_user.add(userRole);
	//
	// user.setRoles(roles_user);
	//
	// }
	// return user;
	// }

}
