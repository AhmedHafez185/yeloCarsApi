/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.controller;
import com.yelo.app.dto.CarDto;
import com.yelo.app.service.CarServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<CarDto> getAllCar() {
        return carService.getAllCar();
    }
    @GetMapping("/{id}")
    public CarDto  getCarById(@PathVariable long id) throws Exception {
    	try {
    		
            return carService.getCarById(id);
    	}catch(Exception ex)
    	 {
    		
    		throw new Exception(String.format("car id not found"));
           }

    }

    @PostMapping("/addCar")
    public CarDto addCar(@RequestBody CarDto carDto) throws Exception {
    	try {
          return carService.addCar(carDto);
    	}catch(Exception ex)
   	      {
    		
   		      throw new Exception(String.format("Data format error"));
          }
    }

    @PutMapping("/{id}")
    public CarDto updateCar(@PathVariable long id, @RequestBody CarDto carDto) throws Exception {
    	try {
         carService.getCarById(id);
         carDto.setId(id);
        return carService.updateCar(carDto);
    	}catch(Exception ex)
   	       {
    		
   		    throw new Exception(String.format("car id not found"));
          }
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) throws Exception {
    	try {
          this.carService.deleteCar(id);
    	}catch(Exception ex)
	       {
    		
		    throw new Exception(String.format("this car  object not found"));
       }
    }
    @GetMapping("/serch")
    public List<CarDto> SerchByNameOrModel(@RequestParam String key) {
    	return this.carService.SerchByNameOrModel(key);
    }
    @GetMapping("/filter")
    public List<CarDto> FilterByNameOrModel(@RequestParam String key){
    	return this.carService.FilterByNameOrModel(key);
    }
}
