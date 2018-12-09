import com.guangfuxiong.proxy.justyaop.servlet.ProductServlet;
import com.guangfuxiong.proxy.justyaop.util.PriList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_aop_pri extends BaseTest{
    @Test
    public void test1(){
        ProductServlet productServlet = (ProductServlet)ac.getBean("productServlet");
        //为用户准备权限
        List<String> list = new ArrayList<String>();
        list.add("add");
        list.add("delete");
        list.add("update");
        PriList.setPriList(list);
        productServlet.updateProduct();
    }
}
