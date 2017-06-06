package com.zingson.sample.mapper;

import com.zingson.sample.model.Blog;

import java.util.List;

public interface BlogMapper {

    int insert(Blog record);

    int updateStatusById(Blog record);

    List<Blog> selectAll();

}