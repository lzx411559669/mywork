package course.weatherDemo;

import com.alibaba.fastjson.JSON;
import course.weatherDemo.mail.Mail;
import course.weatherDemo.model.Weather;


import javax.mail.MessagingException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherNotice {

    private static final ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
    public static void main(String[] args) throws MessagingException {
        //实例天气爬虫

        threadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                WeatherPicker weatherPicker = new WeatherPicker();
                //实例邮箱客户端

                //获取天气ISON
                String info = weatherPicker.getPageContentsync("101230502");
                //转化为weather对象
                Weather weather = JSON.parseObject(info,Weather.class);
                StringBuffer sb =new StringBuffer();

                sb.append("城市："+weather.getWeatherInfo().getCity()+"\n"+"温度："+weather.getWeatherInfo().getTemp()+"\n"+"风向："+weather.getWeatherInfo().getWd()+"\n");
                Mail mailClient = new Mail();
                try {
                    mailClient.sendEmail("411559669","411559669",sb.toString(),"天气预报");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        },1, 100, TimeUnit.MILLISECONDS);


        System.out.println("发送成功");
    }
}
