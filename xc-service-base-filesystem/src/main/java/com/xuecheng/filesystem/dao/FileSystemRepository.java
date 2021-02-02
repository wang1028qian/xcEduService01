package com.xuecheng.filesystem.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/5/9
*/

import com.xuecheng.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileSystemRepository extends MongoRepository<FileSystem,String>{
}
