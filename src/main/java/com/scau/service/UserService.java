package com.scau.service;

import com.scau.dao.UserMapper;
import com.scau.entity.ResponseObject;
import com.scau.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import java.util.Date;

import static com.scau.entity.ServerConstant.*;
import static com.scau.service.State.ERROR;
import static com.scau.service.State.OK;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/24
 * @Time: 20:48
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseObject getUserById(int userId){
        User user=this.userMapper.selectByPrimaryKey(userId);
        if(user==null){
            return new ResponseObject(ERROR, MSG_NOt_EXIST_USER);
        }else{
            return new ResponseObject(OK, MSG_FIND_SUCCESS,user);
        }
    }

    public ResponseObject login(String username,String password){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return  new ResponseObject(ERROR, MSG_BOTH_NOT_NULL);
        }
        User user=this.userMapper.login(username,password);
        if(user==null){
            return new ResponseObject(ERROR, MSG_PASS_NAME_ERROR);
        }else{
            return new ResponseObject(OK, MSG_LOGIN_SUCCESS,user);
        }
    }

    public ResponseObject register(User user){
        if(StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            return  new ResponseObject(ERROR, MSG_BOTH_NOT_NULL);
        }
        if(findUser(user)!=null){
            return new ResponseObject(ERROR,MSG_EXIST_USER);
        }
        userMapper.insertSelectiveDeId(user);
        return new ResponseObject(OK,MSG_REGISTER_SUCCESS,user);
    }

    public User findUser(User user){
        return this.userMapper.login(user.getUsername(),user.getPassword());
    }

    public ResponseObject getAll(){
        return new ResponseObject(State.OK,MSG_GET_ALL_USER,this.userMapper.getAll());
    }
}
