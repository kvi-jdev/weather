package com.example.weatherforecast.service;

import com.example.weatherforecast.model.CustomWeatherDto;
import com.example.weatherforecast.model.WeatherDto;
import org.springframework.http.ResponseEntity;

public interface WeatherService {
    ResponseEntity<WeatherDto> getWeatherByCity(String cityName);
    ResponseEntity<CustomWeatherDto>  getPathWeatherByCity(String cityName);
    ResponseEntity<CustomWeatherDto> getCustomWeatherByCity(CustomWeatherDto customWeatherDto);
}
