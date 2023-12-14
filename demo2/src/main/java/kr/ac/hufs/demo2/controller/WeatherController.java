package kr.ac.hufs.demo2.controller;

import kr.ac.hufs.demo2.dto.WeatherDto;
import kr.ac.hufs.demo2.service.WeatherService;
import kr.ac.hufs.demo2.weather.dto.WeatherRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/current/{city}")
    public WeatherRes getCurrentWeather(@PathVariable String city) {

        return weatherService.getCurrentWeather(city);

    }

    @GetMapping("/curren/geo")
    public WeatherRes getCurrentWeather(@RequestParam Double lat,
                                    @RequestParam Double lon) {

        return weatherService.getCurrentWeatherWithGeo(lat, lon);

    }

}
