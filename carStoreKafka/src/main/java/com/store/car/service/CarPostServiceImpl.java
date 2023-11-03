package com.store.car.service;

import java.util.ArrayList;
import java.util.Date;
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
		 CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDto);
	        carPostRepository.save(carPostEntity);


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
       
	    return new CarPostDto.Builder()
	    		.brand(carPostEntity.getBrand())
				.model(carPostEntity.getModel())
				.price(carPostEntity.getPrice())
				.description(carPostEntity.getDescription())
				.engineVersion(carPostEntity.getEngineVersion())
				.city(carPostEntity.getCity())
				.createdDate(carPostEntity.getCreatedDate())
				.contact(carPostEntity.getContact()).build();
	    		
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
	
	private CarPostEntity mapCarDtoToEntity(CarPostDto carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(item->{
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }


}
