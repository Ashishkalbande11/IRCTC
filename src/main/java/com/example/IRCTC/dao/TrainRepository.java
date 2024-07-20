package com.example.IRCTC.dao;

import com.example.IRCTC.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByTrainNo(Long no);

//    Integer countBySourceAndDestination(String src, String dest);
}
