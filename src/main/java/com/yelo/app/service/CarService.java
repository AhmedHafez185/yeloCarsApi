/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.service;

import com.yelo.app.entity.Car;
import java.util.List;

/**
 *
 * @author Ahmed Hafez
 */
public interface CarService {
    Car addCar(Car car);
    Car updateCar(Car car);
    List<Car> getAllCar();
    Car getCarById(long carId);
    void deleteCar(long id);
}
