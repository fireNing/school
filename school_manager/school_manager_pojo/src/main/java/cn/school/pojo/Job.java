package cn.school.pojo;

import java.io.Serializable;

public class Job implements Serializable {
    private String jid;

    private String post;

    private String jdesc;

    private Double lowpay;

    private Double hightpay;

    private String demand;

    private static final long serialVersionUID = 1L;

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid == null ? null : jid.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getJdesc() {
        return jdesc;
    }

    public void setJdesc(String jdesc) {
        this.jdesc = jdesc == null ? null : jdesc.trim();
    }

    public Double getLowpay() {
        return lowpay;
    }

    public void setLowpay(Double lowpay) {
        this.lowpay = lowpay;
    }

    public Double getHightpay() {
        return hightpay;
    }

    public void setHightpay(Double hightpay) {
        this.hightpay = hightpay;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }
}