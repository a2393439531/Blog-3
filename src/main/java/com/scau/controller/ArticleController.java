package com.scau.controller;

import com.scau.dao.ArticleDetailMapper;
import com.scau.dao.UserMapper;
import com.scau.entity.ArticleDetail;
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

import java.util.Map;

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
    @Autowired
    private ArticleDetailMapper articleDetailMapper;
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
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject delete(@RequestBody Map params){
        if(!CheckParamsUtils.checkIntValue(params,ARTID)){
            return new ResponseObject(State.ERROR, MSG_INVALIDTYPE);
        }
        int artId =(Integer)params.get(ARTID);
        return this.articleService.delete(artId);
    }
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject modify(@RequestBody ArticleDetail articleDetail){
        if(articleDetailMapper.selectByPrimaryKey(articleDetail.getArtDeId())==null){
            return new ResponseObject(State.ERROR,MSG_POST_MODIFY_FAIL,articleDetail);
        }
        return new ResponseObject(State.OK,MSG_POST_MODIFY_SUCCESS,articleDetailMapper.updateByPrimaryKeySelective(articleDetail));
    }
    @RequestMapping(value = "/limit/get",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject getByLimit(@RequestBody Map params){
        return this.articleService.getArticleByLimit(params);
    }
    @RequestMapping(value = "/look/artdel",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject lookArtDel(@RequestBody Map params){
        return this.articleService.lookArtDet(params);
    }
    @RequestMapping(value = "/match",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject matchArt(@RequestBody Map params){
        return this.articleService.selectMatchTitle(params);
    }
    @RequestMapping(value = "/cat/getAll",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject getAllCat(){
        return this.articleService.getAllCat();
    }
    @RequestMapping(value = "/get/catId",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject selCatId(@RequestBody Map params){
        return this.articleService.selectCatId(params);
    }
    @RequestMapping(value = "/addCat",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject addCatNa(@RequestBody Map params){
        return this.articleService.addCatId(params);
    }
    @RequestMapping(value = "/deleteCat",method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject deleteCat(@RequestBody Map params){
        return this.articleService.deleteCatId(params   );
    }
}
