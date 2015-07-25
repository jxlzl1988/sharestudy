package cn.sharestudy.mapper;

import org.springframework.stereotype.Repository;

import cn.sharestudy.mapper.po.User;

@Repository
public interface UserMapper {

    public User selectByUsername(String username) ;
}
