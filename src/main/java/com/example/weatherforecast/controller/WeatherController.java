package com.example.weatherforecast.controller;
import com.example.weatherforecast.model.CustomWeatherDto;
import com.example.weatherforecast.model.WeatherDto;
import com.example.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/", produces = "application/json")
public class WeatherController {

    private WeatherService weatherService;

    @GetMapping(path = "getWeatherByCity/{cityName}")
    public ResponseEntity<WeatherDto> getWeatherByCity(@PathVariable String cityName){
        return weatherService.getWeatherByCity(cityName);
    }

    @GetMapping(path = "getPathWeatherByCity")
    public ResponseEntity<CustomWeatherDto> getPathWeatherByCity(@RequestParam(value = "countryName")String countryName){
        return weatherService.getPathWeatherByCity(countryName);
    }

    @PostMapping(path = "getCustomWeatherByCity")
    public ResponseEntity<CustomWeatherDto> getCustomWeatherByCity(@RequestBody CustomWeatherDto customWeatherDto){
        return weatherService.getCustomWeatherByCity(customWeatherDto);
    }



    @Autowired
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
