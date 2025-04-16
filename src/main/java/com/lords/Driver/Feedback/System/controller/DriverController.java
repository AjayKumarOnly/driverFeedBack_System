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
   // @CrossOrigin(origins = "http://localhost")
    public List<Driver> getDriverDetails(){
        return service.getDriverDetails();
    }

    @GetMapping("/DriverDetails/{driver}")
    public Driver getDriverById(@PathVariable int driver){
        return service.getDriverById(driver);
    }
//    @CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
//    @PostMapping("/DriverDetails/addDriver")
//    public void addDriver(@RequestBody Driver driver){
//         service.addDriver(driver);
//        System.out.println("Driver added successfully!");
//    }
    @PutMapping("/DriverDetails/updateDriver")
    public void updateProduct(@RequestBody Driver driver){
        System.out.println("it is updated");
        service.updateDriver(driver);
    }
    @DeleteMapping("/DriverDetails/{deleteDriver}")
    //@CrossOrigin(origins = "http://localhost")
    public void deleteDriver( @PathVariable int deleteDriver){
        service.deleteDriver(deleteDriver);
    }

    @CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
    @PostMapping("/DriverDetails/addDriver")
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        System.out.println("Incoming Driver: " + driver); // Log the received object
        service.addDriver(driver);
        return ResponseEntity.ok("Driver added successfully!");
    }


}
