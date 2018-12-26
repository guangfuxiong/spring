package mybatis;

import com.guangfuxiong.mybaits.pojo.User;
import com.guangfuxiong.mybaits.pojo.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMabatis_AlisaCatch {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapperConfig.xml");
        //获取sqlsessionFactory工厂类
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //测试sql的复用和别名
    @Test
    public void test01(){
        Integer age = 53;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("mybatis.mapper.aliascatch.findUserByAge",age);
        System.out.println(list);
    }
    //测试mybatis一级缓存
    @Test
    public void test02(){
        /*在sqlSession内部做了三次查询操作，但是sql语句只执行一次。
        Mybaits中默认开启一级缓存。在一级缓存内部共享数据。
        一级缓存默认开启能够提交查询效率*/
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("mybatis.mapper.aliascatch.findAll");
        List<User> userList2 = sqlSession.selectList("mybatis.mapper.aliascatch.findAll");
        List<User> userList3 = sqlSession.selectList("mybatis.mapper.aliascatch.findAll");
        System.out.println(userList);
        System.out.println(userList2);
        System.out.println(userList3);
    }
    //测试mybatis二级缓存
    @Test
    public void test03(){
        /*在sqlSessionFactory内共享数据
          说明：Mybatis中默认的二级缓存是关闭的
          开启二级缓存的步骤：
          1、修改配置文件
          2、添加cache标签
          3、映射对象序列化（此处是User对象需要序列化）
          注意：二级缓存不清楚就不建议用，会可能导致查询数据不准确
        */
        SqlSession sqlSessionA = sqlSessionFactory.openSession();
        List<User> list = sqlSessionA.selectList("mybatis.mapper.aliascatch.findAll");
        System.out.println(list);
        sqlSessionA.close();//先将连接关闭

        SqlSession sqlSessionB = sqlSessionFactory.openSession();
        List<User> list1 = sqlSessionB.selectList("mybatis.mapper.aliascatch.findAll");
        System.out.println(list1);
    }
    //测试mybatis接口形式的增删改查
    @Test
    public void test04(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("UserMapper类:"+userMapper.getClass());
        List<User> list = userMapper.findAll();
        System.out.println(list);
        User user = userMapper.findUserByName("张三");
        System.out.println(user);
    }
}
