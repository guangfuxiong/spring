import com.guangfuxiong.springmvc.controller.HelloController;
import org.junit.Test;

public class Test_springmvc extends BaseTest{
    @Test
    public void test1(){
        HelloController helloController = (HelloController)ac.getBean("/hello.do");
        System.out.println(helloController);
    }
}
