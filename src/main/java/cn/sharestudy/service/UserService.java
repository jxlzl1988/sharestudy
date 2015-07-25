package cn.sharestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sharestudy.mapper.UserMapper;
import cn.sharestudy.mapper.po.User;

@Service
public class UserService extends BaseService {
	
	@Autowired
	private UserMapper userMapper ;
	
	public User getByUsername(String username) {
		return userMapper.selectByUsername(username) ;
	}
}
