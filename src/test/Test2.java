import com.guangfuxiong.Pojo.BRid;
import com.guangfuxiong.Pojo.Food;
import com.guangfuxiong.Pojo.NBA;
import com.guangfuxiong.Pojo.Tiger;
import org.junit.Test;

public class Test2 extends BaseTest {
    @Test
    //包扫描的bean ID生成策略
    public void test1(){
        Tiger tiger = (Tiger)ac.getBean("tiger");
        tiger.run();
        BRid brid = (BRid)ac.getBean("bird");
        brid.flying();
    }
    //注解实现各种bean里的配置
    @Test
    public void test2(){
        NBA nba = (NBA)ac.getBean("NBA");
        nba.exercise();
        //nba.setBeanName("name");
    }
    @Test
    //测试属性动态赋值操作
    public void test3(){
        Food food = (Food)ac.getBean("food");
        System.out.println(food);
    }
}
