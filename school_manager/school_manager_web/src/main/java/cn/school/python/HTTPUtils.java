package cn.school.python;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;

public abstract class HTTPUtils {

    public static HttpResponse getRawHtml(HttpClient client ,String personalUrl ){
        //获取响应文件，采用get获取响应数据
        HttpGet getMethod = new HttpGet(personalUrl);
        getMethod.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");
        try {
            response = client.execute(getMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
