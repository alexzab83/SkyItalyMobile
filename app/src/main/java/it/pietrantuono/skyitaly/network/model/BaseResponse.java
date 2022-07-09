package it.pietrantuono.skyitaly.network.model;

public class BaseResponse {
    private int code;
    private String messege;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
}
