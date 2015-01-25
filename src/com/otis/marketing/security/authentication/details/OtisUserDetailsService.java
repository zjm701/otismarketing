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

	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		Users user = this.userDao.findByName(username);
		
		if (user == null) {
			throw new BadCredentialsException("UserName is Error");
		}
		
		return user;
	}

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
