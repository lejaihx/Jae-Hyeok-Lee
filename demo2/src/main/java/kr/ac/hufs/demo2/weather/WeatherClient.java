package kr.ac.hufs.demo2.weather;

import kr.ac.hufs.demo2.weather.dto.WeatherReq;
import kr.ac.hufs.demo2.weather.dto.WeatherRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@PropertySource("classpath:application-api-key.properties")
public class WeatherClient {

    @Value("${openweather.client.apikey}")
    private String weatherClientApiKey;

    @Value("${openweather.url.weather}")
    private String weatherUrlWeather;

    public WeatherRes getCurrentWeather(WeatherReq weatherReq) {
        weatherReq.setAppId(weatherClientApiKey);

        var uri = UriComponentsBuilder.fromUriString(weatherUrlWeather)
                .queryParams(weatherReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);

        var responseType = new ParameterizedTypeReference<WeatherRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody();
    }

}
