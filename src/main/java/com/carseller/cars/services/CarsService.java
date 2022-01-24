package com.carseller.cars.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carseller.cars.beans.ModelDto;
import com.carseller.cars.domain.Model;
import com.carseller.cars.repositories.CarsRepository;

@Service
public class CarsService implements ICarsService {

	@Autowired
	private CarsRepository repository;

	@Autowired
	private Mapper mapperDozer;

	@Override
	public List<ModelDto> findAll() {
		return
		StreamSupport.stream(
			this.repository.findAll().spliterator(), false
		)
	   .map(from -> mapperDozer.map(from, ModelDto.class))
	   .collect(Collectors.toList());
	}


	@Override
	public List<ModelDto> findAllById(Integer id) {
		return
		StreamSupport.stream(
			this.repository.findAllById(Arrays.asList(id)).spliterator(), false
		)
	   .map(from -> mapperDozer.map(from, ModelDto.class))
	   .collect(Collectors.toList());
	}


	@Override
	public List<ModelDto> findAllByName(String name) {
		return
		StreamSupport.stream(
			this.repository.findAllByName(name).spliterator(), false
		)
	   .map(from -> mapperDozer.map(from, ModelDto.class))
	   .collect(Collectors.toList());
	}

	@Override
	public void save(ModelDto model) {
		if (null != model.getSubModels()) {
			for (ModelDto sm : model.getSubModels().getModels()) {
				this.repository.save(mapperDozer.map(sm, Model.class));
			}
		}
		this.repository.save(mapperDozer.map(model, Model.class));
	}


	@Override
	public void deleteAll() {
		this.repository.deleteAll();
	}


	@Override
	public boolean existsByName(String name) {
		return this.repository.existsByName(name);
	}

}
