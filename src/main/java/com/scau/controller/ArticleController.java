package com.scau.controller;

import com.scau.dao.UserMapper;
import com.scau.entity.ArticleInfo;
import com.scau.entity.ResponseObject;
import com.scau.service.ArticleService;
import com.scau.service.State;
import com.scau.utils.CheckParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.scau.entity.ServerConstant.*;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/29
 * @Time: 22:50
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject post(@RequestBody ArticleInfo params) {
        if(CheckParamsUtils.checkIntNull(params.getUserId())){
            return new ResponseObject(State.ERROR,MSG_NOT_LOGIN);
        }
        else if(userMapper.selectByPrimaryKey(params.getUserId())==null){
            return new ResponseObject(State.ERROR,MSG_NOt_EXIST_USER);
        }
        else if(CheckParamsUtils.checkStrNull(params.getTitle(),params.getSummary())){
            return new ResponseObject(State.ERROR, MSG_TIL_SUM_NOT_NULL);
        }
        return this.articleService.publish(params);
    }
}
