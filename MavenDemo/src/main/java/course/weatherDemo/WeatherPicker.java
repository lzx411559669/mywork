package course.weatherDemo;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class WeatherPicker {
    private OkHttpClient okHttpClient;
    public WeatherPicker(){
        okHttpClient = new OkHttpClient();
    }
    public String getPageContentsync(String cityId){
        String url = "http://www.weather.com.cn/data/sk/"+cityId+".html";
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

}
