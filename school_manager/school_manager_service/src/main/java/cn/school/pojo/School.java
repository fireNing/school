package cn.school.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class School extends SchoolRecruit {

    public School(SchoolRecruit schoolRecruit){
        this.setSid(schoolRecruit.getSid());
        this.setAddress(schoolRecruit.getAddress());
        this.setImage(schoolRecruit.getImage());
        this.setSchoolName(schoolRecruit.getSchoolName());
        Date time1 = schoolRecruit.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.setTimeStr(format.format(time1));
    }

    private String timeStr;

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
