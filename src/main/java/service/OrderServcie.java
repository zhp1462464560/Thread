package service;

public class OrderServcie {

    public String test(){
        try {
            int i = 10/0;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return "success";
    }
}
