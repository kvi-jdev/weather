package com.example.weatherforecast.model;

import com.example.weatherforecast.model.dto.Current;
import com.example.weatherforecast.model.dto.Location;
import com.example.weatherforecast.model.dto.Request;
import lombok.Data;



@Data
public class WeatherDto {

    private Request request;
    private Location location;
    private Current current;


}


