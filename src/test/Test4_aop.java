
import com.guangfuxiong.proxy.aop.service.ProductService;
import com.guangfuxiong.proxy.aop.service.UserService;
import com.guangfuxiong.proxy.aop.service.a.Hello;
import org.junit.Test;

public class Test4_aop extends  BaseTest{
    @Test
    public void test(){
        UserService userService = (UserService)ac.getBean("userService");
        System.out.println(userService.getClass());
        userService.addUser();//连接点
    }
    @Test
    public void test2(){
        ProductService productService = (ProductService)ac.getBean("productService");
        System.out.println(productService.getClass());
        productService.addProduct();
    }
    //测试切入点表达式
    @Test
    public void test3(){
        Hello hello = (Hello)ac.getBean("hello");
        System.out.println(hello.getClass());
        hello.hello();
    }
}
