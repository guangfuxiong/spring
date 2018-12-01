import com.guangfuxiong.proxy.proxy.proxy.DynamicProxy;
import com.guangfuxiong.proxy.proxy.proxy.DynamicProxy_cglib;
import com.guangfuxiong.proxy.proxy.service.UserService;
import com.guangfuxiong.proxy.proxy.tx.TransactionManage;
import com.guangfuxiong.proxy.proxy.web.UserSevlet;
import org.junit.Test;

public class Test3_proxy extends BaseTest{
    @Test
    //静态代理
    public void test1(){
        UserSevlet us = (UserSevlet)ac.getBean("userSevlet");
        //us.addUser();
        us.updateUser();
    }
    @Test
    //JDK动态代理
    public void test2(){
        UserService userService = (UserService)ac.getBean("target");
        TransactionManage tx = (TransactionManage)ac.getBean("tx");
        UserService proxy = (UserService)DynamicProxy.getDynamicProxy(userService,tx);
        //System.out.println(proxy.getClass());//返回的对象是jdk的代理对象，必须传入接口
        proxy.updateUser();
    }
    @Test
    //spring框架自带的cglib动态代理
    public void test3() {
        UserService userService = (UserService)ac.getBean("target");
        TransactionManage tx = (TransactionManage)ac.getBean("tx");
        UserService proxy = (UserService) DynamicProxy_cglib.getDynamciProxy(userService,tx);
        System.out.println(proxy.getClass());//返回的对象是目标对象的子类,可以不用设置接口
        proxy.addUser();
    }
}

