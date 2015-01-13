package com.otis.marketing.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.otis.marketing.dao.UserDao;
import com.otis.marketing.entity.Resources;
import com.otis.marketing.entity.Role;
import com.otis.marketing.entity.Users;

public class OtisUserDetailServiceImpl implements UserDetailsService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Users user = this.userDao.findByName(username);

		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);

		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		User userdetail = new User(user.getUsername(), user.getPassword(),
				enables, accountNonExpired, credentialsNonExpired,
				accountNonLocked, grantedAuths);

		return userdetail;
	}

	private Set<GrantedAuthority> obtionGrantedAuthorities(Users user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<Resources> resources = new ArrayList<Resources>();
		Set<Role> roles = user.getRoles();

		for (Role role : roles) {
			Set<Resources> tempRes = role.getResources();
			for (Resources res : tempRes) {
				resources.add(res);
			}
		}
		for (Resources res : resources) {
			authSet.add(new GrantedAuthorityImpl(res.getName()));
		}
		return authSet;
	}
}
