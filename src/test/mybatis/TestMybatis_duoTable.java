package mybatis;

import com.guangfuxiong.mybaits.pojo.User;
import com.guangfuxiong.mybaits.pojo.UserMapper_duoTable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis_duoTable {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapperConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper_duoTable userMapper = sqlSession.getMapper(UserMapper_duoTable.class);
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }
}
