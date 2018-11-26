import com.guangfuxiong.Pojo.Person;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import com.guangfuxiong.Pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class Test {

    //ApplicationContext ac = null;
    ClassPathXmlApplicationContext ac=null;
    @Before
    public void testBefore(){
        ac = new ClassPathXmlApplicationContext("application.xml");
    }
    @org.junit.Test
    public void test(){
        //User user = (User)ac.getBean("user");//由容器获得
        User user1 = ac.getBean(User.class);//由class类型获得
        User user2 = ac.getBean(User.class);//由class类型获得
        //测试单例还是多例
        System.out.println(user1);
        System.out.println(user2);
        ac.close();
    }
    @org.junit.Test
    //实例工厂
    public void test2(){
        Calendar calendar = (Calendar)ac.getBean("calendar1");
        System.out.println(calendar.getTime());
    }
    @org.junit.Test
    //静态工厂
    public void test3(){
        Calendar calendar = (Calendar)ac.getBean("calendar2");
        System.out.println(calendar.getTime());
    }

    @org.junit.Test
    public void test4(){
        Calendar calendar = (Calendar)ac.getBean("calendar3");
        System.out.println(calendar.getTime());
    }

    @org.junit.Test
    //测试给容器对象赋值
    public void test5(){
        Person person = ac.getBean(Person.class);
        System.out.println(person);
    }
}
