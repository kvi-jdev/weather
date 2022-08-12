package com.example.weatherforecast.serviceImpl;

import com.example.weatherforecast.model.CustomWeatherDto;
import com.example.weatherforecast.model.WeatherDto;
import com.example.weatherforecast.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private RestTemplate restTemplate;
    private CustomWeatherDto customWeatherDto;

    private final String url="http://api.weatherstack.com/current?access_key=bd29c0fd2008fd83d044d1086d0eec39&query=";

    @Override
    public ResponseEntity<WeatherDto> getWeatherByCity(String cityName) {
        String url=this.url+cityName;
        ResponseEntity<WeatherDto> result=restTemplate.getForEntity(url,WeatherDto.class);
        WeatherDto responseBody=result.getBody();
        return ResponseEntity.ok(responseBody);

    }

    @Override
    public ResponseEntity<CustomWeatherDto> getPathWeatherByCity(String cityName) {
        String url=this.url+cityName;
        ResponseEntity<WeatherDto> result=restTemplate.getForEntity(url,WeatherDto.class);
        if(result.getStatusCode().value()!= 200){
            throw new NullPointerException();
        }
        WeatherDto responseBody=result.getBody();
        assert responseBody != null;
        this.customWeatherDto.setCityName(responseBody.getLocation().getName());
        this.customWeatherDto.setLocalDateTime(responseBody.getLocation().getLocaltime());
        this.customWeatherDto.setTemperature(responseBody.getCurrent().getTemperature());


        return ResponseEntity.ok(this.customWeatherDto);
    }

    @Override
    public ResponseEntity<CustomWeatherDto> getCustomWeatherByCity(CustomWeatherDto customWeatherDto) {
        String url=this.url+customWeatherDto.getCityName();
        ResponseEntity<WeatherDto> result=restTemplate.getForEntity(url,WeatherDto.class);
        WeatherDto responseBody=result.getBody();
        assert responseBody != null;
        customWeatherDto.setCityName(responseBody.getLocation().getName());
        customWeatherDto.setLocalDateTime(responseBody.getLocation().getLocaltime());
        customWeatherDto.setTemperature(responseBody.getCurrent().getTemperature());


        return ResponseEntity.ok(customWeatherDto);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setCustomWeatherDto(CustomWeatherDto customWeatherDto) {
        this.customWeatherDto = customWeatherDto;
    }
}
