/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.service;

import com.yelo.app.entity.Car;
import com.yelo.app.exceptions.ResourceNotFoundException;
import com.yelo.app.repository.CarRepositoy;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepositoy carRepository;
    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }
    @Override
    public Car updateCar(Car car) {
        Optional <Car> newCar = this.carRepository.findById(car.getId());

        if (newCar.isPresent()) {
            Car updatedCar = newCar.get();
            updatedCar.setId(car.getId());
            updatedCar.setName(car.getName());
            updatedCar.setHideMe(car.getHideMe());
            updatedCar.setColor(car.getColor());
            updatedCar.setOwner(car.getOwner());
            updatedCar.setModel(car.getModel());
            carRepository.save(updatedCar);
            return updatedCar;
        } else {
            return car;
        }
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(long carId) {
        Optional <Car> car = carRepository.findById(carId);
        if (car.isPresent()) {
            return car.get();
        } else{
            return new Car();
        }
    }

    @Override
    public void deleteCar(long id) {
        Optional <Car> car = this.carRepository.findById(id);

        if (car.isPresent()) {
            this.carRepository.delete(car.get());
        } 
    }
}
