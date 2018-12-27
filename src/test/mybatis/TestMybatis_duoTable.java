package mybatis;

import com.guangfuxiong.mybaits.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestMybatis_duoTable {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapperConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //测试一对一的封装（一位User对应一个dept）
    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper_duoTable userMapper = sqlSession.getMapper(UserMapper_duoTable.class);
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }
    //测试一对多的封装（一个dept对应多个User）
    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper_duoTable deptMapper = sqlSession.getMapper(DeptMapper_duoTable.class);
        List<Dept> list = deptMapper.findDeptAll();
        for(Dept dept : list){
            System.out.println(dept);
        }
    }
    //测试多对多的封装（一个student有多个teacher，一个teacher有多个student）
    @Test
    public void test03(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper_duoTable studentMapper = sqlSession.getMapper(StudentMapper_duoTable.class);
//        List<Student> list = studentMapper.findAll();
        List<Map<String,Object>> list = studentMapper.findAll();
        for(Map s : list){
            System.out.println(s);
        }
    }
}
