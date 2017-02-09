package domain;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by zhangxiao3 on 2017/2/7.
 */
public class MybatisUtil {
    private final static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

//    public Display getDidplaydetail() {
//        Display display = null;
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try {
//            DisplayDao displayDao = sqlSession.getMapper(DisplayDao.class);
//            display = displayDao.selectByDisplayCode("60200316115");
//            System.out.println(display);
//        } finally {
//            sqlSession.close();
//        }
//        return display;
//    }
}
