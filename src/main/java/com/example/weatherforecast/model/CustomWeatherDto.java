package com.example.weatherforecast.model;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class CustomWeatherDto {
    @NotNull(message = "City name is empty!")

    private String cityName;
    private String localDateTime;
    private Integer temperature;

}
