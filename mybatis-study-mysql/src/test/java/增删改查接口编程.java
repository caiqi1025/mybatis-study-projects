import mybatis.entity.User;
import mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class 增删改查接口编程 {
    @Test
    public void addUser() {

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            User user = new User();
            user.setUserName("lisi");
            user.setPassword("123456");
            user.setNickname("caiqi");
			UserMapper userMapper = session.getMapper(UserMapper.class);
			int result = userMapper.addUser(user);
            System.out.println("返回结果:" + result);
            /**
             * 关闭session
             */
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
