package com.store.car.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.car.dto.CarPostDto;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;

@Service
public class CarPostServiceImpl implements CarPostService {

	@Autowired
	private CarPostRepository carPostRepository;

	@Autowired
	private OwnerPostRepository ownerPostRepository;

	@Override
	public void newPostDetails(CarPostDto carPostDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CarPostDto> getCarSales() {
		List<CarPostDto> listCarsSales = new ArrayList<>();
		carPostRepository.findAll().forEach(item -> {
			listCarsSales.add(mapCarEntityToDto(item));
		});
		return listCarsSales;
	}

	private CarPostDto mapCarEntityToDto(CarPostEntity carPostEntity) {

		return CarPostDto.builder().brand(carPostEntity.getBrand()).city(carPostEntity.getCity())
				.model(carPostEntity.getModel()).description(carPostEntity.getDescription())
				.engineVersion(carPostEntity.getEngineVersion()).createdDate(carPostEntity.getCreatedDate())
				.ownerName(carPostEntity.getOwnerPost().getName()).price(carPostEntity.getPrice()).build();

	}

	@Override
	public void changeCarSale(CarPostDto carPostDTO, Long postId) {

		carPostRepository.findById(postId).ifPresentOrElse(item -> {
			item.setDescription(carPostDTO.getDescription());
			item.setContact(carPostDTO.getContact());
			item.setPrice(carPostDTO.getPrice());
			item.setBrand(carPostDTO.getBrand());
			item.setEngineVersion(carPostDTO.getEngineVersion());
			item.setModel(carPostDTO.getModel());

			carPostRepository.save(item);

		}, () -> {
			throw new NoSuchElementException();
		});
	}

	@Override
	public void removeCarSale(Long postId) {
		carPostRepository.deleteById(postId);
	}

}
