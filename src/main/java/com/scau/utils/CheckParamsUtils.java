package com.scau.utils;

import java.util.Map;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/28
 * @Time: 20:31
 * 检查参数工具
 */
public final class CheckParamsUtils {
    public static boolean checkStrValue(Map map, String ... paramsName){
        for(String paramName:paramsName){
            if(!(map.get(paramName)instanceof String)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkIntValue(Map map, String ... paramsName){
        for(String paramName:paramsName){
            if(!(map.get(paramName)instanceof Integer)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkStrValue(String ... paramsValue){
        for(String paramName: paramsValue){
            if(!(paramName instanceof String)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkDateValue(java.sql.Date... paramsValue){
        for(java.sql.Date paramName: paramsValue){
            if(!(paramName instanceof java.sql.Date)){
                return false;
            }
        }
        return true;
    }
}
