/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yelo.app.service;

import com.yelo.app.dto.CarDto;
import com.yelo.app.entity.Car;
import com.yelo.app.repository.CarRepositoy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepositoy carRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarDto addCar(@Valid CarDto carDto) {
        Car car = convertToEntity(carDto);
        carRepository.save(car);
        carDto.setId(car.getId());
        return carDto;
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        Car car = convertToEntity(carDto);
        Optional<Car> newCar = this.carRepository.findById(car.getId());
        if (newCar.isPresent()) {
            Car updatedCar = newCar.get();
            updatedCar.setId(car.getId());
            updatedCar.setName(car.getName());
            updatedCar.setHideMe(car.getHideMe());
            updatedCar.setColor(car.getColor());
            updatedCar.setOwner(car.getOwner());
            updatedCar.setModel(car.getModel());
            carRepository.save(updatedCar);
            return carDto;
        } else {
            return carDto;
        }
    }

    @Override
    public List<CarDto> getAllCar() {
        List<Car> allCars = carRepository.findAll();
        List<CarDto> allCars2 = new ArrayList<CarDto>();
        for (Car car : allCars) {
            CarDto carDto = convertToDto(car);
            allCars2.add(carDto);
        }
        return allCars2;
    }

    @Override
    public CarDto getCarById(long carId) {
        return convertToDto(carRepository.findById(carId).get());

    }

    @Override
    public void deleteCar(long id) {
        carRepository.delete(this.carRepository.findById(id).get());
    }

    @Override
    public CarDto convertToDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);

        return carDto;
    }

    @Override
    public Car convertToEntity(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        return car;
    }
    @Override
    public List<CarDto> SearchByNameOrOwner(String key) {
        String pattern = "%"+key+"%";
        List<Car> allCars = carRepository.SearchByNameOrOwner(pattern);
        List<CarDto> allCars2 = new ArrayList<CarDto>();
        for (Car car : allCars) {
            CarDto carDto = convertToDto(car);
            allCars2.add(carDto);
        }
        return allCars2;

    }
    public List<CarDto> FilterByNameOrModel(String key) {
        List<Car>allCars=carRepository.findAll(Sort.by(Sort.Direction.ASC,key));
        List<CarDto> allCars2 = new ArrayList<CarDto>();
        for (Car car : allCars) {

            CarDto carDto = convertToDto(car);
            System.out.println(carDto.getModel());
            allCars2.add(carDto);
        }
        return allCars2;

    }
}
