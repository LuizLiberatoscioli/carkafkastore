package com.store.car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.car.dto.CarPostDto;

@Service
public interface CarPostService {
	
	void newPostDetails(CarPostDto carPostDto) ;
	
	List<CarPostDto> getCarSales();
	
	void changeCarSale(CarPostDto carPostDto , Long postId);
	
	void removeCarSale(Long postId);
	
	

}
