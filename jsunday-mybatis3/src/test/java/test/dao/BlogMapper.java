package test.dao;

import java.util.List;
import test.model.Blog;

public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZT_BLOG
     *
     * @mbg.generated
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZT_BLOG
     *
     * @mbg.generated
     */
    List<Blog> selectAll();
}