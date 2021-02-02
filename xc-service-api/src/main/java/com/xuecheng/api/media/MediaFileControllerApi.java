package com.xuecheng.api.media;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/25
*/

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.domain.media.request.QueryMediaFileRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "媒体文件管理",description = "媒体文件管理接口",tags = {"媒体文件管理接口"})
public interface MediaFileControllerApi {
    @ApiOperation("我的媒资查询列表")
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest);
}
