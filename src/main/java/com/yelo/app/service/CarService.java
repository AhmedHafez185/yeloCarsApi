/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.service;

import com.yelo.app.dto.CarDto;
import com.yelo.app.entity.Car;
import java.util.List;

/**
 *
 * @author Ahmed Hafez
 */
public interface CarService {

    public CarDto addCar(CarDto carDto);

    public CarDto updateCar(CarDto carDto);

    public List<CarDto> getAllCar();

    public CarDto getCarById(long carId);

    public void deleteCar(long id);

    public Car convertToEntity(CarDto carDto);

    public CarDto convertToDto(Car car);

    public List<CarDto> SearchByNameOrOwner(String key);

    public List<CarDto> FilterByNameOrModel(String key);
}
