package cn.school.service;

import cn.school.utils.E3Result;

public interface SearchService {

    public E3Result selectAllSchoolRecruit(Integer page, Integer row);

    public E3Result selectSchoolRecruitByKeyword(Integer page, Integer row, String keyword);

    public E3Result selectSchoolInfoById(String sid);

    public E3Result selectJobByCid(String cid);

    public E3Result selectCompanyByPost(String post);

    public E3Result selectCompanyMajor(String majorName);

}
