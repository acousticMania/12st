
package com.mall.admin.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mall.admin.user.dao.UserDao;
import com.mall.admin.user.vo.UserDetailsVO;
import com.mall.common.util.QueryMapper;

@Service
public class UserAuthenticationService extends QueryMapper implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationService.class);
	
	@Resource
	private UserDao userDao;
	
	public UserAuthenticationService() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Map<String, Object> user = userDao.selectUser(username);
		if(user == null) throw new UsernameNotFoundException(username);
		logger.info(user.toString());
		boolean bol = (Long)user.get("enabled") == 1;
		List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		gaList.add(new SimpleGrantedAuthority(user.get("authority").toString()));
		return new UserDetailsVO(user.get("username").toString(), user.get("password").toString(), bol, true, true, true, gaList);
	}

}
