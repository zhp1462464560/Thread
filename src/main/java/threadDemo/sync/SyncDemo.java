package threadDemo.sync;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SyncDemo implements Runnable{

     private int count = 0;

    @Override
    public void run() {
        count++;
        System.err.println(Thread.currentThread().getName()+":"+count);
    }

    public static void main(String[] args) {
//        SyncDemo sync = new SyncDemo();
//        for (int i = 0; i < 1000; i++) {
//            new Thread(sync,"thread:"+ i).start();
//        }
        System.err.println(4%10);
        Map<String,Object> put = new HashMap<>();
        put.put("a", "b");
        String s = JSON.toJSONString(put);
        JSONObject jsonObject = JSON.parseObject(s);
        String b = jsonObject.getString("b");
        System.err.println(b);
    }


}
