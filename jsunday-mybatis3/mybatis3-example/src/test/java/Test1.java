/**
 * 代码片段
 */
public class Test1 {

    /**
     SqlSession session = sqlSessionFactory.openSession();
     try {
     Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
     } finally {
     session.close();
     }
    对比 ----------------------------------------------------------------------
     SqlSession session = sqlSessionFactory.openSession();
     try {
     BlogMapper mapper = session.getMapper(BlogMapper.class);
     Blog blog = mapper.selectBlog(101);
     } finally {
     session.close();
     }

     */


}
