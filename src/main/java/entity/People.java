package entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class People {

    static Logger logger = LoggerFactory.getLogger(People.class);
    private  String name;

    private int age;

    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
//        User user = new User();
//        user.setAge(1);
//        user.setName("张三");
//        user.setBirthday(new Date());
//        People people = new People();
//        BeanUtils.copyProperties(user,people);
//        System.err.println(people.getAge()+","+people.getName()+","+people.getBirthday());
        try {
            List<Map<String,Object>> equityPackageCodeList = new ArrayList<>();
            Map<String,Object> map = new HashMap<>();
            Map<String,Object> map1 = new HashMap<>();
            Map<String,Object> map2 = new HashMap<>();
            Map<String,Object> map3 = new HashMap<>();
            Map<String,Object> map4 = new HashMap<>();
            map.put("equityPackageCode","1");
            map1.put("equityPackageCode","2");
            map2.put("equityPackageCode","3");
            map3.put("equityPackageCode","4");
            equityPackageCodeList.add(map);
            equityPackageCodeList.add(map1);
            equityPackageCodeList.add(map2);
            equityPackageCodeList.add(map3);
            map4.put("equityPackageCodeList",equityPackageCodeList);
            String s = JSON.toJSONString(map4);
            System.err.println(s);
            //int i =10 / 0 ;
        } catch (Exception e) {
            logger.error("XXX={}",e.getMessage(),e);
        }

    }
}
