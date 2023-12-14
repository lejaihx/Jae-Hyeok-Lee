package kr.ac.hufs.demo2.service;

import kr.ac.hufs.demo2.dto.WeatherDto;
import kr.ac.hufs.demo2.weather.WeatherClient;
import kr.ac.hufs.demo2.weather.dto.WeatherCityReq;
import kr.ac.hufs.demo2.weather.dto.WeatherGeoReq;
import kr.ac.hufs.demo2.weather.dto.WeatherRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;

    public WeatherRes getCurrentWeather(String city) {
        var weatherReq = new WeatherCityReq();
        weatherReq.setCity(city);

        var weatherRes = weatherClient.getCurrentWeather(weatherReq);


        return weatherRes;
    }

    public WeatherRes getCurrentWeatherWithGeo(Double lat, Double lon) {
        var weatherReq = new WeatherGeoReq();
        weatherReq.setLat(lat);
        weatherReq.setLon(lon);

        var weatherRes = weatherClient.getCurrentWeather(weatherReq);

        return weatherRes;
    }
}






