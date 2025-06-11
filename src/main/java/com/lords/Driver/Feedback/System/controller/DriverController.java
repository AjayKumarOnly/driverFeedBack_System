package com.lords.Driver.Feedback.System.controller;

import com.lords.Driver.Feedback.System.drivers.Driver;
import com.lords.Driver.Feedback.System.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService service;

    @GetMapping("/DriverDetails")
    public List<Driver> getDriverDetails(){
        return service.getDriverDetails();
    }

    @GetMapping("/DriverDetails/{driver}")
    public Driver getDriverById(@PathVariable int driver){
        return service.getDriverById(driver);
    }

    @PutMapping("/DriverDetails/updateDriver")
    public void updateProduct(@RequestBody Driver driver){
        System.out.println("it is updated");
        service.updateDriver(driver);
    }

    @DeleteMapping("/DriverDetails/{deleteDriver}")
    public void deleteDriver(@PathVariable int deleteDriver){
        service.deleteDriver(deleteDriver);
    }

    @PostMapping("/DriverDetails/addDriver")
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        System.out.println("Incoming Driver: " + driver);
        service.addDriver(driver);
        return ResponseEntity.ok("Driver added successfully!");
    }
}
