package cn.school.python;

import cn.school.pojo.Recruit;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

    public static List<Recruit> getData(String html,String sId)throws Exception{
        //将数据存在集合中
        List<Recruit> data = new ArrayList<>();
        //采用jsoup解析
        Document doc = Jsoup.parse(html);
        if (sId.equals("4")) {
            String title = doc.select("div[class=title]").text();
            Elements trs = doc.select("tbody").select("tr");
            for (Element tr : trs) {
                String name = tr.select("a[target=_blank]").text();
                String job = tr.select("td:nth-child(3)").text();
                Recruit recruit = new Recruit();
                recruit.setTitle(title);
                recruit.setName(name);
                recruit.setJob(job);
                data.add(recruit);
            }
        }else if(sId.equals("8")){
            String title = doc.select("span[style=color:#626262;font-family:宋体;font-size:16pt;mso-bidi-font-size:10.0pt;mso-bidi-font-family:宋体;mso-font-kerning:0pt;]").text();
            Elements companyNames = doc.select("table").select("tbody").select("td:nth-child(2)");
            for (Element companyName : companyNames) {
                String name = companyName.select("p").select("span").text();
                Recruit recruit = new Recruit();
                recruit.setTitle(title);
                recruit.setName(name);
                data.add(recruit);
            }
        }else if(sId.equals("1")){
            String Newtime = null;
            Elements timeList = doc.select("div[class=list_news]").select("ul").select("li");
            for (Element times : timeList) {
                Recruit recruit = new Recruit();
                String time = times.select("li[style]").text();

                if(StringUtils.isNotBlank(time)){
                    Newtime = time;
                }
                Elements companyNames = times.select("li").select("a[href]");
                for (Element names : companyNames) {
                    String name = names.text();
                    recruit.setTime(Newtime);
                    recruit.setName(name);
                    data.add(recruit);
                }
            }
        }else if(sId.equals("10")){
            Elements elements = doc.select("table[id=customers]").select("tbody").select("tr[class=alt]");
            for (Element element : elements) {
                Recruit recruit = new Recruit();
                String name = element.select("td:nth-child(2)").text();
                String time = element.select("td:nth-child(3)").text();
                recruit.setTime(time);
                recruit.setName(name);
                data.add(recruit);
            }
        }else if(sId.equals("3")){
            Elements elements = doc.select("div[class=contentWrap]").select("ul").select("li");
            for (Element element : elements) {
                String time = element.select("span").text();
                String name = element.select("a[href]").text();
                Recruit recruit = new Recruit();
                recruit.setTime(time);
                recruit.setName(name);
                data.add(recruit);
            }
        }
        //String job = doc.select("tbody").select("tr").select("td:nth-child(3)").text();
        return data;
    }

}
