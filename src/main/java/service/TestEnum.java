package service;

public enum TestEnum {

    success("0000","success"),

    error("0001","error");

    private String code;

    private String msg;

    TestEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static void main(String[] args) {
        System.err.println(TestEnum.success.code+"   "+TestEnum.success.getMsg());
    }
}
