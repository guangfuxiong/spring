package mybatis;


import com.guangfuxiong.mybaits.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis{
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        //读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapperConfig.xml");
        //获取sqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    //查询所有
    public void test1(){
        //从sqlSession工厂获取sqlSession对象，它才是与数据库沟通的桥梁，类似于jdbc中的connection
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //实现数据库操作（调用映射文件的namespace+id）
        List<User> list = sqlSession.selectList("mybatis.mapper.findAll");
        System.out.println(list);
    }
    @Test
    //查询单个
    public void test2(){
        //从sqlSession工厂获取sqlSession对象，它才是与数据库沟通的桥梁，类似于jdbc中的connection
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String name = "张三";
        Map map = new HashMap<>();
        map.put("name","李四");
        map.put("age","13");
        User user = sqlSession.selectOne("mybatis.mapper.findUserByName",map);
        System.out.println(user);
    }
    //用户新增
    @Test
    public void test03(){
        User user = new User();
        user.setName("红牛");
        user.setAge(23);
        user.setSex("未知");

        SqlSession session = sqlSessionFactory.openSession();
        //将User参数传递给mybatis
        int rows = session.insert("mybatis.mapper.addUser",user);
        System.out.println("影响行数为:"+rows);
        session.commit();
    }
    //更新用户
    @Test
    public void test04(){
        User user = new User();
        user.setName("绿牛");
        user.setAge(43);
        user.setSex("男");
        user.setId(8);

        SqlSession session = sqlSessionFactory.openSession();
        //将User参数传递给mybatis
        int rows = session.update("mybatis.mapper.updateUser",user);
        System.out.println(rows);
        session.commit();
    }

}
