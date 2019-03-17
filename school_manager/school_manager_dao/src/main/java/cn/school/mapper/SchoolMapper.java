package cn.school.mapper;

import cn.school.pojo.Company;
import cn.school.pojo.Job;

import java.util.List;

public interface SchoolMapper  {

    public List<Company> getSchool4CompanyById(String sid);

    public List<Job> getJobByCid(String cid);

    public List<Company> getCompanyByPost(String post);

    public List<Company> getCompanyByMajor(String majorName);

}
