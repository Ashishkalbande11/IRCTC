package com.example.IRCTC.model;

import com.example.IRCTC.enumm.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ticketId;

    Long trainNo;

    @Column(unique = true)
    String name;

    Date date;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonIgnore
    Train train;
}
