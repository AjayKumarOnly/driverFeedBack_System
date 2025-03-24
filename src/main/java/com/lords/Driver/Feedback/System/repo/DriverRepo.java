package com.lords.Driver.Feedback.System.repo;

import com.lords.Driver.Feedback.System.drivers.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Integer> {

}
