package com.livegoods.commons.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一的返回结果类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveGoodsResult implements Serializable {
    private int status;
    private Object results;
    private Object data;
    private boolean hasMore;
    private long time;
    private String msg;

    public static LiveGoodsResult ok(){
        return new LiveGoodsResult(200,null,null,false,
                0L,"OK");
    }

    public static LiveGoodsResult okWithResults(Object results){
        return new LiveGoodsResult(200,results,null,false,
                0L,"OK");
    }

    public static LiveGoodsResult okWithData(Object data){
        return new LiveGoodsResult(200,null,data,false,
                0L,"OK");
    }

    public static LiveGoodsResult error(String msg){
        return new LiveGoodsResult(500,null,null,false,
                0L,msg);
    }

}
