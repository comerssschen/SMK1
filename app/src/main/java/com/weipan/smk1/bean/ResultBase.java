package com.weipan.smk1.bean;

public class ResultBase {
    private String code = "";
    private String msg = "";
    private String sub_code = "";
    private String sub_msg = "";
    private String sign = "";
    private boolean is_error = true;
    private String data = "";

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

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_msg() {
        return sub_msg;
    }

    public void setSub_msg(String sub_msg) {
        this.sub_msg = sub_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean getIs_error() {
        return is_error;
    }

    public void setIs_error(boolean is_error) {
        this.is_error = is_error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBase{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", sub_code='" + sub_code + '\'' +
                ", sub_msg='" + sub_msg + '\'' +
                ", sign='" + sign + '\'' +
                ", is_error='" + is_error + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
