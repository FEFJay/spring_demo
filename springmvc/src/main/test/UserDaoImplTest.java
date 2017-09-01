import com.jay.dao.UserDao;
import com.jay.entities.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class UserDaoImplTest {
    private static Logger logger = Logger.getLogger(UserDaoImplTest.class);

    public static void main(String[] args) {
        testSpringMybatis();
    }

    private static void testSpringMybatis(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        //获得会话对象
        SqlSession session = factory.openSession(true);
        try {
            //通过MyBatis实现接口UserDAO，返回实例
            UserDao userDao = session.getMapper(UserDao.class);
            List<User> users = userDao.getAllUsers();
            System.out.println(users);
            users.forEach(user-> logger.info(user.getId()+","+user.getName()+","+user.getAddress()));
        } finally {
            session.close();
        }

    }


    private static void testMybatis(){
        System.out.println("hi");
        // 获得环境配置文件流
        InputStream config = UserDaoImplTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis.xml");
        // 创建sql会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        //获得会话对象
        SqlSession session = factory.openSession(true);
        try {
            //通过MyBatis实现接口UserDAO，返回实例
            UserDao userDao = session.getMapper(UserDao.class);
            List<User> users = userDao.getAllUsers();
            System.out.println(users);
            users.forEach(user-> System.out.println(user.getId()+","+user.getName()+","+user.getAddress()));
        } finally {
            session.close();
        }
    }
}
