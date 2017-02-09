package domain;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by zhangxiao3 on 2017/2/7.
 */
public class Test {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

//    public static void main(String[] args) {
//        getUser();
//    }


//    public static void getUser() {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try {
//            DisplayDao displayDao = sqlSession.getMapper(DisplayDao.class);
//            Display display = displayDao.selectByDisplayCode("60200316115");
//            System.out.println(display);
//        } finally {
//            sqlSession.close();
//        }
//    }
}
