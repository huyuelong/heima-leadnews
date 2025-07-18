package com.heima.model.article.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleHomeDto {

    // 最大时间
    @ApiModelProperty(value = "最大时间戳")
    Date maxBehotTime;

    // 最小时间
    @ApiModelProperty(value = "最小时间戳")
    Date minBehotTime;

    // 分页size
    @ApiModelProperty(value = "分页size")
    Integer size;

    // 频道ID
    @ApiModelProperty(value = "频道ID")
    String tag;
}