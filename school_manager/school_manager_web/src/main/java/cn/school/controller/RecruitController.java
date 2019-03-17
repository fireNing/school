package cn.school.controller;

import cn.school.pojo.Recruit;
import cn.school.python.URLFecter;
import cn.school.utils.E3Result;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecruitController {

    @RequestMapping("/recruit/{sId}")
    @ResponseBody
    public E3Result getResultBySchoolId(@PathVariable String sId){
        String url = null;
        //初始化一个httpclient
        HttpClient client = HttpClientBuilder.create().build();
        List<Recruit> data = new ArrayList<>();
        if(sId.equals("4")){
            //广东工业大学招聘会信息
            //爬取的地址
            url = "http://job.gdut.edu.cn/unijob/index.php/web/Index/jobfair-com-all?id=74";
            //抓取的数据
            try {
                data = URLFecter.URLParser(client, url,sId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(sId.equals("8")){
            //华南理工大学招聘会信息
            //爬取地址
            url = "http://jyzx.6ihnep7.cas.scut.edu.cn/jyzx/big_pics/1d1adn94dce3l.xhtml";
            try {
                data = URLFecter.URLParser(client, url,sId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(sId.equals("1")){
            url = "http://job.gdupt.edu.cn/index.php?m=Article&a=index&id=36";
            try {
                data = URLFecter.URLParser(client, url, sId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(sId.equals("10")){
            url = "http://career.scnu.edu.cn/SchoolRecruitment/index";
            try {
                data = URLFecter.URLParser(client, url, sId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(sId.equals("3")){
            url = "http://xsc.dgut.edu.cn/job/zpxx/zxqy/";
            try {
                data = URLFecter.URLParser(client, url, sId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return E3Result.ok(data);

    }

}
