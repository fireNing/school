package cn.school.python;

import cn.school.pojo.Recruit;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class URLFecter {

    public static List<Recruit> URLParser(HttpClient client, String url,String sId)throws Exception {
        //接收解析的数据
        List<Recruit> companyData = new ArrayList<>();
        //获取网站响应
        HttpResponse response = HTTPUtils.getRawHtml(client, url);
        //获取状态码
        int code = response.getStatusLine().getStatusCode();
        if(code == 200){
            //状态码为200，将html转化成json
            String entity = EntityUtils.toString(response.getEntity(), "utf-8");
            companyData = ParseUtils.getData(entity,sId);
            EntityUtils.consume(response.getEntity());
        }else {
            EntityUtils.consume(response.getEntity());
        }
        return companyData;
    }


}
