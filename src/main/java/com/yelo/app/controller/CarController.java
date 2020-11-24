/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.controller;

import com.yelo.app.dto.CarDto;
import com.yelo.app.exceptions.CarValidator;
import com.yelo.app.exceptions.ErrorDetails;
import com.yelo.app.service.CarServiceImpl;
import java.time.LocalDateTime;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    CarValidator carValidator;
    @Autowired
    CarServiceImpl carService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public List<CarDto> getAllCar() {
        return carService.getAllCar();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable long id) throws Exception {
        try {
            return carService.getCarById(id);
        } catch (Exception ex) {

            throw new NotFoundException(String.format("Car Id Not Found"));
        }

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/addCar")
    public ErrorDetails addCar(@RequestBody CarDto carDto, BindingResult result) throws Exception {
        carValidator.validate(carDto, result);
        if (result.hasErrors()) {
            // throw new InvalidDataException(result);
            throw new Exception(String.format("Missing , Some Data Required !!"));
        }
        try {
            System.out.println("layer1");
            if(carDto.getId()!=null && carDto.getId() != 0){
            if (carService.getCarById(carDto.getId()) != null) {
                System.out.println("layer0");
                throw new Exception(String.format("This Object IS Exists !!"));
            }}
            System.out.println("layer2");
            carService.addCar(carDto);
            System.out.println("layer4");
            return new ErrorDetails("success", "cars/addCar", LocalDateTime.now());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ErrorDetails updateCar(@PathVariable long id, @RequestBody CarDto carDto) throws Exception {
        try {
          carService.getCarById(id);
         System.out.println("here");
         carDto.setId(id);
         System.out.println("here2");
         carService.updateCar(carDto);
         System.out.println("here3");
         return new ErrorDetails("success","cars/updateCar",LocalDateTime.now());

        } catch (Exception ex) {
            throw new Exception(String.format("Car Id Not Found"));
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable long id) throws Exception {
        boolean flag = false;
        try {
            this.carService.deleteCar(id);
            flag = true;
        } catch (Exception ex) {

            throw new Exception(String.format("this car  object not found"));
        }
        return flag;
    }

  
    

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/search/{key}")
    public List<CarDto> SearchByNameOrModel(@PathVariable String key) {
        return this.carService.SearchByNameOrOwner(key);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/filter/{key}")
    public List<CarDto> FilterByNameOrModel(@PathVariable String key) {
        return this.carService.FilterByNameOrModel(key);
    }
}
