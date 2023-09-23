package com.car.service;


import com.car.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    void save(Car car);

    void delete(String id);

    Car find(String id);

    void update(Car car);
}
