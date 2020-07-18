package course;

import com.alibaba.fastjson.JSON;
import course.weatherDemo.PageOperator;
import course.weatherDemo.model.Weather;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

public class getPage {
    private OkHttpClient okHttpClient;
    public getPage(){
        okHttpClient = new OkHttpClient();
    }
    public String getPageContentsync(String url){
        if (StringUtils.isBlank(url)){
            return null;
        }
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        String result = null;
        try {
            result = call.execute().body().string();
            System.out.println("call "+url+"centent's size is "+result.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        PageOperator pageOperator = new PageOperator();
        String info = pageOperator.getPageContentsync("http://neteaseapi.youkeda.com:3000/artists?id=6452");
        Map returnMap = JSON.parseObject(info,Map.class);
       // System.out.println("city="+weather.getWeatherInfo().getCity());
      //  System.out.println(info);
        Map artistData = (Map) returnMap.get("artist");
        System.out.println(artistData.get("img1v1Id").toString());

    }
}
