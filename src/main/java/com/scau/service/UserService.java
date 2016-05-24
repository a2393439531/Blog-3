package com.scau.service;

import com.scau.dao.UserMapper;
import com.scau.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/24
 * @Time: 20:48
 */
@Service("userService")
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(int userId)
    {
        return this.userMapper.selectByPrimaryKey(userId);
    }
}
