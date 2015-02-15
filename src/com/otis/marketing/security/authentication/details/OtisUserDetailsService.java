package com.otis.marketing.security.authentication.details;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Users;

public class OtisUserDetailsService implements UserDetailsService {

	private UserDao userDao;

	
	// 因为user实现了userDatils 接口，所以就可以直接返回user
		// 在这里必须启用事务管理,否则会导致session提前关闭
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		Users user = this.userDao.findByName(username);
		
		if (user == null) {
			throw new BadCredentialsException("UserName is Error");
		}
		
		return user;
	}
	
	// 获取用户权限集合，权限使用用GrantedAuthority表示，框架中 有他的实现类
	// GrantedAuthorityImpl 只需把角色名称放入即可
	public Collection<GrantedAuthority> getGrantedAuthorities(User user) {
		return user.getAuthorities();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
