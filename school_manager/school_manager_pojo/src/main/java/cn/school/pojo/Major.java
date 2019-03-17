package cn.school.pojo;

import java.io.Serializable;

public class Major implements Serializable {
    private String mid;

    private String nane;

    private static final long serialVersionUID = 1L;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane == null ? null : nane.trim();
    }
}