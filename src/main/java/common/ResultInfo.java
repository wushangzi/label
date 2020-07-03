package common;


/**
 * @author chengyongjun
 * @date 2020/7/3 16:11
 */
public class ResultInfo {

    public boolean isSuccess() {
        return code == 200 ? true : false;
    }

    private Integer code = 200;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
