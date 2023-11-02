package com.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDto {
	
	
	 private String model;
	    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

		private String brand;
	    private Double price;
	    private String description;
	    private String engineVersion;
	    private String city;
	    private String createdDate;
	    private Long ownerId;
	    private String ownerName;
	    private String ownerType;
	    private String contact;

	    private CarPostDto() {
	        // Construtor privado para impedir instâncias diretas.
	    }

	    public static class Builder {
	        private String model;
	        private String brand;
	        private Double price;
	        private String description;
	        private String engineVersion;
	        private String city;
	        private String createdDate;
	        private Long ownerId;
	        private String ownerName;
	        private String ownerType;
	        private String contact;

	        public Builder model(String model) {
	            this.model = model;
	            return this;
	        }

	        public Builder brand(String brand) {
	            this.brand = brand;
	            return this;
	        }

	        public Builder price(Double price) {
	            this.price = price;
	            return this;
	        }

	        public Builder description(String description) {
	            this.description = description;
	            return this;
	        }

	        public Builder engineVersion(String engineVersion) {
	            this.engineVersion = engineVersion;
	            return this;
	        }

	        public Builder city(String city) {
	            this.city = city;
	            return this;
	        }

	        public Builder createdDate(String createdDate) {
	            this.createdDate = createdDate;
	            return this;
	        }

	        public Builder ownerId(Long ownerId) {
	            this.ownerId = ownerId;
	            return this;
	        }

	        public Builder ownerName(String ownerName) {
	            this.ownerName = ownerName;
	            return this;
	        }

	        public Builder ownerType(String ownerType) {
	            this.ownerType = ownerType;
	            return this;
	        }

	        public Builder contact(String contact) {
	            this.contact = contact;
	            return this;
	        }

	        public CarPostDto build() {
	            CarPostDto carPostDto = new CarPostDto();
	            carPostDto.model = this.model;
	            carPostDto.brand = this.brand;
	            carPostDto.price = this.price;
	            carPostDto.description = this.description;
	            carPostDto.engineVersion = this.engineVersion;
	            carPostDto.city = this.city;
	            carPostDto.createdDate = this.createdDate;
	            carPostDto.ownerId = this.ownerId;
	            carPostDto.ownerName = this.ownerName;
	            carPostDto.ownerType = this.ownerType;
	            carPostDto.contact = this.contact;
	            return carPostDto;
	        }
	    }

	    public static Builder builder() {
	        return new Builder();
	    }

		
	}