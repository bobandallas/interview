package org.example.controller;


import org.example.pojo.dto.RewardResponseDTO.*;
import org.example.pojo.entity.Customer;
import org.example.pojo.entity.Transaction;
import org.example.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RewardController {
    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    //return summary of customer's transactions
    @GetMapping("/reward")
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return new ResponseEntity<>(rewardService.getAll(), HttpStatus.OK);
    }
}
