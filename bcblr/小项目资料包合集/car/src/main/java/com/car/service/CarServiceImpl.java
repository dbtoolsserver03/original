package com.car.service;


import com.car.dao.CarDAO;
import com.car.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;

    @Override
    public void update(Car car) {
        carDAO.update(car);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Car find(String id) {
        return carDAO.find(id);
    }

    @Override
    public void delete(String id) {
        carDAO.delete(id);
    }

    @Override
    public void save(Car car) {
        car.setId(UUID.randomUUID().toString());
        carDAO.save(car);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Car> findAll() {
        return carDAO.findAll();
    }
}
