package com.example.IRCTC.controller;

import com.example.IRCTC.model.Passenger;
import com.example.IRCTC.model.Train;
import com.example.IRCTC.service.IRCTC_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class IRCTC_Controller {

    private final IRCTC_Service irctcService;

    @PostMapping("/add-train")
    public String addTrain(@RequestBody Train train){
         irctcService.addTrain(train);
         return "train registered";
    }

    @PostMapping("/add-passenger")
    public String addPassenger(@RequestBody Passenger passenger){
        irctcService.addPassenger(passenger);
        return "passenger registered";
    }
    @GetMapping("book")
    public Passenger bookTrain(@RequestParam Long trainNo, @RequestParam String name){
        return irctcService.bookTrain(trainNo, name);
    }

    @GetMapping("/trainNo/{trainNo}")
    public Train getTrain(@PathVariable Long trainNo){
        return irctcService.getTrain(trainNo);
    }

    @GetMapping("/all")
    public Integer getPassengers(@RequestParam String src, @RequestParam String dest){
        return irctcService.getTotalPassengers(src, dest);
    }
    @GetMapping("/all-female")
    public Integer findAllFemalePassenger(@RequestParam Integer x, @RequestParam Integer y){
        return irctcService.findAllFemalePassengerAgeBetween(x,y);
    }
}
