package com.carseller.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carseller.cars.domain.Model;

@Repository
public interface CarsRepository extends CrudRepository<Model, Integer> {

	public List<Model> findAllByName(String name);

	public boolean existsByName(String name);

}
