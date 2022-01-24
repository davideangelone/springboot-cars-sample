package com.carseller.cars.services;

import java.util.List;

import com.carseller.cars.beans.ModelDto;

public interface ICarsService {

	public List<ModelDto> findAll();

	public List<ModelDto> findAllById(Integer id);

	public List<ModelDto> findAllByName(String name);

	public boolean existsByName(String name);

	public void save(ModelDto model);

	public void deleteAll();

}
