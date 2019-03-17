package cn.school.service.impl;

import cn.school.mapper.SchoolRecruitMapper;
import cn.school.pojo.*;
import cn.school.mapper.SchoolMapper;
import cn.school.pojo.School;
import cn.school.service.SearchService;
import cn.school.utils.E3Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SchoolRecruitMapper schoolRecruitMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    /**
     * 查询所有的企业
     * @return
     */
    public E3Result selectAllSchoolRecruit(Integer page , Integer row) {
        PageHelper.startPage(page, row);
        SchoolRecruitExample example = new SchoolRecruitExample();
        List<SchoolRecruit> schoolRecruitList = schoolRecruitMapper.selectByExample(example);
        PageInfo<SchoolRecruit> info = new PageInfo<>(schoolRecruitList);
        SearchPager pager = new SearchPager();
        long total = info.getTotal();
        pager.setTotal(total);
        List<SchoolRecruit> list = info.getList();
        List<School> schoolList = new ArrayList<>();
        for (SchoolRecruit recruit : list) {
            School school = new School(recruit);
            schoolList.add(school);
        }
        pager.setRows(schoolList);
        return E3Result.ok(pager);
    }

    /**
     * 根据keyword查询相关学校信息
     * @param page
     * @param row
     * @param keyword
     * @return
     */
    public E3Result selectSchoolRecruitByKeyword(Integer page, Integer row, String keyword) {
        PageHelper.startPage(page, row);
        SchoolRecruitExample example = new SchoolRecruitExample();
        SchoolRecruitExample.Criteria criteria = example.createCriteria();
        criteria.andSchoolNameLike("%"+keyword+"%");
        List<SchoolRecruit> schoolRecruits = schoolRecruitMapper.selectByExample(example);
        PageInfo<SchoolRecruit> info = new PageInfo<>(schoolRecruits);
        SearchPager pager = new SearchPager();
        pager.setTotal(info.getTotal());
        pager.setRows(info.getList());
        return E3Result.ok(pager);
    }

    /**
     * 根据学校Id查询学校招聘会详情
     * @param sid
     * @return
     */
    public E3Result selectSchoolInfoById(String sid) {
        List<Company> Companylist = schoolMapper.getSchool4CompanyById(sid);
        return E3Result.ok(Companylist);
    }

    /**
     * 根据cid 查询相关职业信息
     * @param cid
     * @return
     */
    public E3Result selectJobByCid(String cid) {
        List<Job> jobList = schoolMapper.getJobByCid(cid);
        return E3Result.ok(jobList);
    }

    /**
     * 根据职位搜索公司
     * @param post
     * @return
     */
    public E3Result selectCompanyByPost(String post) {
        List<Company> companyList = schoolMapper.getCompanyByPost(post);
        return E3Result.ok(companyList);
    }

    /**
     * 根据专业查找公司
     * @param majorName
     * @return
     */
    public E3Result selectCompanyMajor(String majorName){
        String newMajorName = "%"+majorName+"%";
        List<Company> companyList = schoolMapper.getCompanyByMajor(newMajorName);
        return E3Result.ok(companyList);
    }
}
