package com.scau.service;

import com.scau.dao.ArticleDetailMapper;
import com.scau.dao.ArticleMapper;
import com.scau.dao.CateoryMapper;
import com.scau.dao.TagMapper;
import com.scau.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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
    public ResponseObject publish(ArticleInfo articleInfo){
        Article article=new Article();
        List<Cateory> cateories;
        Cateory cateory=null;
        if(StringUtils.isEmpty(articleInfo.getCatName())){
            //article.setCatId(0);
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
        Tag tag=new Tag();
        tag.setTagName(articleInfo.getTagName());
        tag.setArtId(article.getArtId());
        tagMapper.insertSelectiveDeId(tag);
        return new ResponseObject(State.OK,ServerConstant.MSG_POST_SUCCESS,new ArticleResponse(article,cateory,tag));
    }
}
