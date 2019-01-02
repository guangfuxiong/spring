package springSSM;

import com.guangfuxiong.springSSM.entity.User;
import com.guangfuxiong.springSSM.service.UserService;
import com.guangfuxiong.springSSM.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SSMTest {
    ClassPathXmlApplicationContext applicationContext;
    private UserService userService;
    @Before
    public void init(){
        applicationContext    = new ClassPathXmlApplicationContext("springSSM/applicationContext.xml");
        userService = (UserService)applicationContext.getBean("userServiceImpl");
    }
    @Test
    public void test01(){
        List<User> list =  userService.findAll();
        System.out.println(list);
    }
}
