package com.livegoods.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "banner")//访问Mongodb需要的注解，
public class Banner implements Serializable {
    @Id
    private Long id;
    private Date createTime;
    private Date beginTime;
    private Date endTime;
    private String url;
}
