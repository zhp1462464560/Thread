import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.OrderServcie;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Lazy
public class DemoTest {

    public static void main(String[] args) {

//        try {
//            new OrderServcie().test();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Map map = new HashMap();
//        map.put("age",20);
//        map.put("name","tom");
//        map.put("grade",6);
//        String toJSONString = JSON.toJSONString(map);
//        System.err.println(toJSONString);
//        JSONObject jsonObject = JSON.parseObject(toJSONString);
//        String name = jsonObject.getString("name");
//        String t = jsonObject.getString("t");
//        System.out.println("name:"+name+"\t"+"t"+t);

//        Date millisecondDate= new Date(System.currentTimeMillis());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String millisecondStrings = formatter.format(millisecondDate);
//        System.out.println(millisecondStrings);
//        new ClassPathXmlApplicationContext("");
//        System.err.println(File.separatorChar);
//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        user.setName("zs");
//        user.setAge(20);
//        user1.setName("ls");
//        user1.setAge(21);
//        user2.setName("ww");
//        user2.setAge(22);
//        user3.setName("zl");
//        user3.setAge(23);
//        user4.setName("tq");
//        user4.setAge(24);
//
//        ArrayList<User> list = new ArrayList<>();
//        list.add(user);
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.add(user4);
//        Map<String,Object> map = new HashMap<>();
//        map.put("userList",list);
//        map.put("code","0000");
//        String jsonString = JSON.toJSONString(map);
//        System.err.println(jsonString);
//        JSONObject jsonObject = JSONObject.parseObject(jsonString);
//        System.err.println(jsonObject);
//        JSONArray userList = jsonObject.getJSONArray("userList");
//        List<Object> objList = new ArrayList<>();
//        for (Object obj : userList) {
//            objList.add(obj);
//        }
//        userList.getJSONObject(1);
//        System.out.println(userList);
//        System.err.println(objList);

    }

    /**
     * 循环依赖
     * A注入了B，同时B注入了A，先从容器中获取A，调用getBean，之后调用doGetBean，调用getSingleton()方法，从缓存中拿，没有
     * 的话判断当前是否正在创建中，没有返回空，然后调用调用getSingleton，传入了一个createBean方法，这个要说一下ObjectFactory
     * 这个接口是可以传入lambda表达式的，然后调用getObject方法，执行createBean，然后找doCreateBean,调用createBeanInstance
     * 实例化Bean，然后判断是否单例，是否允许循环依赖，是的话会先调用一个addSingletonFactory将一个getEarlyBeanReference方法
     * 加入三级缓存，然后进行填充属性，获取属性名字，还有属性的值(RuntimeBeanReference),然后通过值处理器判断是不是这个类型，
     * 是的话处理引用resolveReference，A里面的值是B，所以调用this.beanFactory.getBean方法获取B，然后就是和A相同的流程，直到
     * 填充属性，他会去继续getBean(A），然后解析属性值，继续去getBean(A),但是这次有个判断可以进去了，当前的A正在创建中，他会
     * 先从一级缓存找，没有的话判断是否在创建中，然后在二级缓存找，没有的话再去三级缓存找，获取到的是一个lambda表达式，就是
     * 那个getEarlyBeanReference方法，当调用getObject的时候就是执行这个方法，然后返回一个半成品的A对象，然后将A加入到二级缓存
     * 同时删除三级缓存，然后给B里面的A属性赋值，这时候B就是一个完整的对象了，然后将B对象加入到一级缓存，同时删除二三级缓存，
     * 然后继续回调，把完整的B对象赋值给A对象的B属性，这时A也是完整对象了，然后加入一级缓存，同时删除二三级缓存，这时候
     * 循环依赖就解决了，一级缓存是存放所有bean对象的地方，同时因为是创建bean的循环，所以b也要创建，当getBean(B)的时候，从
     * 一级缓存就可以拿到一个完整的Bean对象了，所有不需要再去创建了
     */

    /**
     * 创建Bean工厂，加载配置文件或者扫描路径将扫描到的bean通过beanDefinitionReader封装成beanDefinition，
     * 执行beanFactoryPostProcessor，实例化所有非懒加载的bean，初始化，执行aware接口，执行beanPostProcessor的before方法，
     * 执行init-method方法，执行after方法，获取，销毁
     */
}
