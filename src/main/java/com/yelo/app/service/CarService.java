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

    CarDto addCar(CarDto carDto);

    CarDto updateCar(CarDto carDto);

    List<CarDto> getAllCar();

    CarDto getCarById(long carId);

    void deleteCar(long id);

    Car convertToEntity(CarDto carDto);

    CarDto convertToDto(Car car);
}
