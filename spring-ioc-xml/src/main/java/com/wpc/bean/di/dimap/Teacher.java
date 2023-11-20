package com.wpc.bean.di.dimap;

/**
 * @author wpc
 * @date 2023/10/10 15:28
 */
public class Teacher {
    private String tid;
    private String sname;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
