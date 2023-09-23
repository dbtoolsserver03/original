package com.car.dao;

import com.car.entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarDAO {

    List<Car> findAll();

    void save(Car car);

    void delete(String id);

    Car find(String id);

    void update(Car car);
}
