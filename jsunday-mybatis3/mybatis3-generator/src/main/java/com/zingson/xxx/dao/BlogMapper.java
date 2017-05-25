package com.zingson.xxx.dao;

import com.zingson.xxx.model.Blog;
import java.util.List;

public interface BlogMapper {

    int insert(Blog record);

    List<Blog> selectAll();
}