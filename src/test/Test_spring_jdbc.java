import com.guangfuxiong.springjdbc.mapper.UserMapper;
import com.guangfuxiong.springjdbc.pojo.User;
import com.guangfuxiong.springjdbc.servlet.UserServlet;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Test_spring_jdbc extends BaseTest {
    @Test
    public void test1() throws SQLException {//测速最原始的获取结果集的方法
        //获取数据源
        DataSource dataSource = (DataSource)ac.getBean("dataSource");
        //获取连接
        Connection conn = dataSource.getConnection();
        //从连接中获取预编译对象
        String sql = "select * from user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setAge(rs.getInt(3));
            user.setName(rs.getString("name"));
            System.out.println(user);
        }
    }
    @Test
    //测试spring自带的jdbcTemplate模板作用
    public void test2() throws SQLException {//插入语句
        //获取jdbc模板
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
        String sql = "insert into user values (null,?,?)";
        int row = jdbcTemplate.update(sql,"小黄",15);
        System.out.println(row);
    }
    @Test
    public void test3(){//查询
        //获取jdbc模板
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
        String sql = "select * from user";
        List<Map<String, Object>> list =jdbcTemplate.queryForList(sql);
        System.out.println(list);
    }
    @Test
    public void test4(){//查询
        //获取jdbc模板
        JdbcTemplate jdbcTemplate_spring = (JdbcTemplate)ac.getBean("jdbcTemplate_spring");
        JdbcTemplate jdbcTemplate_tedu = (JdbcTemplate)ac.getBean("jdbcTemplate_tedu");
        String sql = "select * from user";
        UserMapper userMapper = new UserMapper();
        List<User> list1 = jdbcTemplate_spring.query(sql,userMapper);
        List<User> list2 = jdbcTemplate_tedu.query(sql,userMapper);
        System.out.println(list1);
        System.out.println(list2);
    }
    @Test
    public void test5(){//测试更新查询
        JdbcTemplate jdbcTemplate_spring = (JdbcTemplate)ac.getBean("jdbcTemplate_spring");
        String sql = "update user set name = ? where id = ?";
        int row = jdbcTemplate_spring.update(sql,"玉皇大帝",1);
        System.out.println(row);
        String sql1 = "select * from user where id = ?";
        RowMapper rowMapper = new BeanPropertyRowMapper<User>(User.class);//该方法慢，建议手动封装
        User user = (User) jdbcTemplate_spring.queryForObject(sql1,rowMapper,1);
        System.out.println(user);
    }
    @Test
    public void test6(){
        UserServlet userServlet = (UserServlet)ac.getBean("userServlet");
        //增
        User user = new User();
        user.setName("李大");
        user.setAge(53);
        userServlet.addUser(user);
        System.out.println("添加用户成功");
        //删
        userServlet.delUserById(1);
        System.out.println("删除成功");
        //改
        User userUpdate = new User();
        userUpdate.setName("王五");
        userUpdate.setAge(11);
        userUpdate.setId(2);
        userServlet.updateUser(userUpdate);
        //查(所有)
        List<User> list = userServlet.findUserAll();
        System.out.println(list);
        //查(单个)
        User getUser = userServlet.findUserById(4);
        System.out.println(getUser);
    }
    //测试spring自带的事务管理
    @Test
    public void test7(){
        UserServlet userServlet = (UserServlet)ac.getBean("userServlet");
        //改
        User userUpdate = new User();
        userUpdate.setName("王器");
        userUpdate.setAge(11);
        userUpdate.setId(2);
        userServlet.updateUser(userUpdate);
    }
    @Test
    public void test8(){
        UserServlet userServlet = (UserServlet)ac.getBean("userServlet");
        //查
        System.out.println(userServlet.findUserAll());
    }

}
