import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    //ApplicationContext ac = null;
            ClassPathXmlApplicationContext ac=null;
    @Before
    public void testBefore(){
        //Test1
        //ac = new ClassPathXmlApplicationContext("application-1.xml");
        //Test2
        ac = new ClassPathXmlApplicationContext("application-2.xml");
    }
    @After
    public void testAfter(){
        ac.close();
    }
}
