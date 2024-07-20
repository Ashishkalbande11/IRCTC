package com.example.IRCTC.dao;

import com.example.IRCTC.enumm.Gender;
import com.example.IRCTC.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByName(String name);

    @Query(value = "select count(*) from passenger p where p.train_no in (select  t.train_no from train t where t.source = :src and t.destination = :dest)",nativeQuery = true)
    Integer countBySourceAndDestination(String src, String dest);

    @Query(value = "select count(*) from passenger p where p.age >= :x and p.age <= :y and p.gender = 'female'", nativeQuery = true)
    Integer findByAgeBetween(Integer x, Integer y);
}
