package org.example.service;

import org.example.pojo.dto.RewardResponseDTO;


import java.util.List;

public interface RewardService {
    //return all customer's DTO
    List<RewardResponseDTO.CustomerDTO> getAll();
}
