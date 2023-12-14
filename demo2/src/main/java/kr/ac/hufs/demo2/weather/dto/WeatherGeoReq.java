package kr.ac.hufs.demo2.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherGeoReq extends WeatherReq {
    private Double lat;
    private Double lon;

    @Override
    public MultiValueMap<String, String> toMultiValueMap() {
        var map = new LinkedMultiValueMap<String, String>();

        map.add("lat", lat.toString());
        map.add("lon", lon.toString());
        map.add("appid", appId);

        return map;
    }
}
