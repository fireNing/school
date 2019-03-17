package cn.school.controller;

import cn.school.service.SearchService;
import cn.school.utils.E3Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Value(value = "${PAGE_SIZE}")
    private Integer row;

    /**
     * 首页查询显示所有的学校招聘会信息
     * @param page
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public E3Result selectAllSchoolRecruit(@RequestParam(defaultValue = "1") Integer page){
        return searchService.selectAllSchoolRecruit(page,row);
    }

    /**
     * 搜索学校名称显示招聘会信息
     * @param page
     * @param keyword
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/search")
    @ResponseBody
    public E3Result selectSchoolRecruitByKeyword(@RequestParam(defaultValue = "1") Integer page,String keyword) throws UnsupportedEncodingException {
        keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
        return searchService.selectSchoolRecruitByKeyword(page, row, keyword);

    }

    /**
     * 根据学校ID查询详情
     * @param sId
     * @return
     */
    @RequestMapping("/info/{sId}")
    @ResponseBody
    public E3Result selectSchoolInfoById(@PathVariable String sId){
        return searchService.selectSchoolInfoById(sId);
    }

    /**
     * 根据学校ID查找工作
     * @param cid
     * @return
     */
    @RequestMapping("/job/{cid}")
    @ResponseBody
    public E3Result selectJobByCid(@PathVariable String cid){
        E3Result result = searchService.selectJobByCid(cid);
        return result;
    }

    /**
     * 根据职位查找公司
     * @param post
     * @return
     */
    @RequestMapping("/company/{post}")
    @ResponseBody
    public E3Result selectPostByCompanyId(@PathVariable String post){
        return searchService.selectCompanyByPost(post);
    }

    @RequestMapping("/work/{major}")
    @ResponseBody
    public E3Result selectCompanyByMajor(@PathVariable String major){ return searchService.selectCompanyMajor(major);
    }

}
