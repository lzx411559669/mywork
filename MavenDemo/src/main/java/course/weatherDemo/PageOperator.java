package course.weatherDemo;

import com.alibaba.fastjson.JSON;
import course.weatherDemo.model.Weather;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;


public class PageOperator {

   private OkHttpClient okHttpClient;
   public PageOperator(){
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
       String info = pageOperator.getPageContentsync("http://www.weather.com.cn/data/sk/101040200.html");
        Weather weather = JSON.parseObject(info,Weather.class);
        System.out.println("city="+weather.getWeatherInfo().getCity());
        System.out.println(info);
    }
}
