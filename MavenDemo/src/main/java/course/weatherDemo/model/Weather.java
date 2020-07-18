package course.weatherDemo.model;

import java.io.Serializable;

public class Weather implements Serializable {
    private WeatherInfo weatherInfo;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}
