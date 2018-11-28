import com.guangfuxiong.proxy.staticproxy.proxy.StaticProxy;
import com.guangfuxiong.proxy.staticproxy.web.UserSevlet;
import org.junit.Test;

public class Test3_proxy extends BaseTest{
    @Test
    public void test1(){
        UserSevlet us = (UserSevlet)ac.getBean("userSevlet");
        //us.addUser();
        us.updateUser();
    }
}
