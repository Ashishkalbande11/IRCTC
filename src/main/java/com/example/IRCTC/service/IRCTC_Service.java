package com.example.IRCTC.service;

import com.example.IRCTC.dao.PassengerRepository;
import com.example.IRCTC.dao.TrainRepository;
import com.example.IRCTC.model.Passenger;
import com.example.IRCTC.model.Train;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class IRCTC_Service {

    private final TrainRepository trainRepository;
    private final PassengerRepository passengerRepository;


    public void addTrain(Train train) {
        trainRepository.save(train);
    }

    public void addPassenger(Passenger passenger) {
         passengerRepository.save(passenger);
    }

    public Passenger bookTrain(Long trainNo, String name) {

        Train train = trainRepository.findByTrainNo(trainNo);
        Passenger passenger = passengerRepository.findByName(name);
        if(train == null || passenger == null){
            throw new RuntimeException("something went wrong!");
        }
        passenger.setTrainNo(trainNo);
        passenger.setName(passenger.getName());
        passenger.setDate(new Date());
        passenger.setGender(passenger.getGender());
        passenger.setTicketId(train.getTrainId());
        passenger.setTrain(train);
        train.getPassengerList().add(passenger);
        trainRepository.save(train);
        return passengerRepository.save(passenger);

    }

    public Train getTrain(Long trainNo) {
        return trainRepository.findByTrainNo(trainNo);
    }

    public Integer getTotalPassengers(String src, String dest) {
        return passengerRepository.countBySourceAndDestination(src, dest);
    }

    public Integer findAllFemalePassengerAgeBetween(Integer x, Integer y) {
        return passengerRepository.findByAgeBetween(x,y);
    }
}
