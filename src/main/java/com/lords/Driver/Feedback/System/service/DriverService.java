package com.lords.Driver.Feedback.System.service;

import com.lords.Driver.Feedback.System.drivers.Driver;
import com.lords.Driver.Feedback.System.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepo repo;

    public List<Driver> getDriverDetails(){
        return repo.findAll();
    }
    public Driver getDriverById( int d){
        return repo.findById(d).orElse(new Driver());

    }
    public void addDriver(Driver d){
        repo.save(d);
    }
    public void updateDriver(Driver d){
        repo.save(d);
    }
    public void deleteDriver(int d){
        repo.deleteById(d);
    }

}
