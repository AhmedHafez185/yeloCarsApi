/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.controller;

import com.yelo.app.entity.Car;
import com.yelo.app.service.CarServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmed Hafez
 */
@RestController
@RequestMapping("/cars")

public class CarController {
    @Autowired
    CarServiceImpl carService;
    
   @GetMapping()
    public List<Car> getAllCar() {
        return carService.getAllCar();
    }
    @GetMapping("/{id}")
    public Car  getCarById(@PathVariable long id) {
        return carService.getCarById(id);
    }

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car) {
        car.setId(id);
        return carService.updateCar(car);
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        this.carService.deleteCar(id);
    }
    
}
