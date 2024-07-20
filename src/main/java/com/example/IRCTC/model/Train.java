package com.example.IRCTC.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long trainId;

    @Column(unique = true)
    Long trainNo;

    @Column(unique = true)
    String name;

    String source;

    String destination;


    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    List<Passenger> passengerList;
}
