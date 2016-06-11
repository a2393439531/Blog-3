package com.scau.controller;

import com.scau.entity.ResponseObject;
import com.scau.entity.User;
import com.scau.service.State;
import com.scau.service.UserService;
import com.scau.utils.CheckParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static com.scau.entity.ServerConstant.*;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/22
 * @Time: 21:08
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject queryUser(@RequestBody Map params) {
        if(!CheckParamsUtils.checkIntValue(params,ID)){
            return new ResponseObject(State.ERROR, MSG_INVALIDTYPE);
        }
        int userId =(Integer)params.get(ID);
        return this.userService.getUserById(userId);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject login(@RequestBody Map params) {
        if(!CheckParamsUtils.checkStrValue(params,USERNAME,PASSWORD)){
            return new ResponseObject(State.ERROR,MSG_INVALIDTYPE);
        }
        String username=(String)params.get(USERNAME);
        String password=(String)params.get(PASSWORD);
        return this.userService.login(username,password);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject register(@RequestBody User user) {
        return this.userService.register(user);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject getAll(){
        return this.userService.getAll();
    }
}
