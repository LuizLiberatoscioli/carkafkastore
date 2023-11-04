package com.store.car.service;

import org.springframework.stereotype.Service;

import com.store.car.dto.OwnerPostDto;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDto ownerPostDto);


}
