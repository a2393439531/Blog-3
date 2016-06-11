package com.scau.service;

import com.scau.dao.*;
import com.scau.entity.*;
import com.scau.utils.CheckParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import static com.scau.entity.ServerConstant.ARTID;
import static com.scau.entity.ServerConstant.MSG_INVALIDTYPE;
import static com.scau.entity.ServerConstant.MSG_NOt_EXIST_USER;
import static com.scau.service.State.ERROR;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/29
 * @Time: 20:27
 */
@Service("articleService")
public class ArticleService {
    @Autowired
    CateoryMapper  cateoryMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    ArticleDetailMapper articleDetailMapper;
    @Autowired
    private UserMapper userMapper;
    public ResponseObject publish(ArticleInfo articleInfo){
        Article article=new Article();
        List<Cateory> cateories;
        Cateory cateory=null;
        if(StringUtils.isEmpty(articleInfo.getCatName())){
            cateory=cateoryMapper.selectByPrimaryKey(0);
            //+article.setCatId(0);
        }else{
            cateories=cateoryMapper.queryByName(articleInfo.getCatName());
            if(cateories.size()>0)
                cateory=cateories.get(0);
            if(cateory!=null&&cateory.getCatId()>=0){
                article.setCatId(cateory.getCatId());
            }else{
                cateory=new Cateory();
                cateory.setCatName(articleInfo.getCatName());
               // cateory.setCatId(cateoryMapper.getCount()+1);
                cateoryMapper.insertSelectiveDeId(cateory);
            }
        }
        article.setCatId(cateory.getCatId());
        article.setTitle(articleInfo.getTitle());
        article.setSummary(articleInfo.getSummary());
        article.setUserId(articleInfo.getUserId());
        article.setPublishDate(new Date(System.currentTimeMillis()));
        articleMapper.insertSelectiveDeId(article);
        ArticleDetail articleDetail=new ArticleDetail();
        articleDetail.setArtDeId(article.getArtId());
        articleDetail.setContent(articleInfo.getContent());
        articleDetailMapper.insert(articleDetail);
        Tag tag=new Tag();
        tag.setTagName(articleInfo.getTagName());
        tag.setArtId(article.getArtId());
        tagMapper.insertSelectiveDeId(tag);
        return new ResponseObject(State.OK,ServerConstant.MSG_POST_SUCCESS,new ArticleResponse(article,cateory,tag));
    }
    public ResponseObject delete(Integer artId){
        int a=articleDetailMapper.deleteByPrimaryKey(artId);
        int b=articleMapper.deleteByPrimaryKey(artId);
        if(a>0&&b>0)
            return new ResponseObject(State.OK,ServerConstant.MSG_POST_DELETE_SUCCESS);
        else
            return new ResponseObject(State.ERROR,ServerConstant.MSG_POST_DELETE_FAIL);
    }

    public ResponseObject getArticleByLimit(Map map){
        User user=this.userMapper.selectByPrimaryKey((Integer) map.get("userId"));
        if(user==null){
            return new ResponseObject(ERROR, MSG_NOt_EXIST_USER);
        }
        ArticleLimit articleLimit=new ArticleLimit();
        articleLimit.setCount(articleMapper.getCount(map));
        articleLimit.setArticles(articleMapper.selectBylimit(map));
        return new ResponseObject(State.OK,ServerConstant.MSG_GET_LIMIT_POST,articleLimit);
    }

    public ResponseObject lookArtDet(Map map){
        if(!CheckParamsUtils.checkIntValue(map,ARTID)){
            return new ResponseObject(State.ERROR, MSG_INVALIDTYPE);
        }
        ArticleDetail articleDetail=this.articleDetailMapper.selectByPrimaryKey((Integer) map.get(ServerConstant.ARTID));
        int click=0;
        if(articleDetail!=null){
            if(articleDetail.getArticleClick()==null){
                click=1;
            }else
            {
                click=1+articleDetail.getArticleClick();
            }
            articleDetail.setArticleClick(click);
            articleDetailMapper.updateByPrimaryKey(articleDetail);
            return new ResponseObject(State.OK,ServerConstant.MSG_LOOK_POST_SUCCESS,articleDetail);
        }
        else {
            return new ResponseObject(State.ERROR,ServerConstant.MSG_POST_NOT_EXIST);
        }
    }

    public ResponseObject selectMatchTitle(Map map){
        return new ResponseObject(State.OK,ServerConstant.MSG_GET_MATCH_POST,this.articleMapper.selectMatchTitle(map));
    }

    public ResponseObject getAllCat(){
        return new ResponseObject(State.OK,ServerConstant.MSG_GET_ALL_CAT,this.cateoryMapper.getAll());
    }

    public ResponseObject selectCatId(Map params){
        return new ResponseObject(State.OK,ServerConstant.MSG_GET_POST_CATID,this.articleMapper.selectByCatId(params));
    }

    public ResponseObject addCatId(Map params){
        if(cateoryMapper.queryByName((String) params.get(ServerConstant.CATNA)).size()>0){
            return new ResponseObject(State.ERROR,ServerConstant.MSG_ADD_CAT_FAIL);
        }
        else{
            Cateory cateory=new Cateory();
            cateory.setCatName((String) params.get(ServerConstant.CATNA));
            this.cateoryMapper.insertSelectiveDeId(cateory);
            return new ResponseObject(State.OK,ServerConstant.MSG_ADD_CAT,cateory);
        }
    }

    public ResponseObject deleteCatId(Map params){
        int id=this.cateoryMapper.deleteByPrimaryKey((Integer) params.get(ServerConstant.CATID));
        if(id>0){
            return new ResponseObject(State.OK,ServerConstant.MSG_DELETE_CAT_SUCCESS,id);
        }else {
            return new ResponseObject(State.ERROR,ServerConstant.MSG_DELETE_CAT_FAIL);
        }
    }
}
