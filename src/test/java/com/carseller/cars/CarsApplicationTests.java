package com.carseller.cars;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.carseller.cars.beans.EngineDto;
import com.carseller.cars.beans.ModelDto;
import com.carseller.cars.beans.WheelsDto;
import com.carseller.cars.controllers.CarsController;
import com.carseller.cars.repositories.CarsRepository;
import com.carseller.cars.services.ICarsService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)

@SpringBootTest
@Slf4j
public class CarsApplicationTests {

    @Autowired
    CarsRepository repository;

    @Autowired
    CarsController controller;

    @Autowired
    ICarsService service;

	@Before
    public void initDatabase() {
		 log.info("Begin initDatabase");

		 EngineDto e = new EngineDto();
		 e.setPower(100);
		 e.setType("engineType");

		 WheelsDto w = new WheelsDto();
		 w.setSize("50");
		 w.setType("wheelsType");

		 ModelDto m = new ModelDto();
		 m.setEngine(e);
		 m.setWheels(w);
		 m.setName("modelName");


		 ResponseEntity<?> result = controller.add(m, null);
		 assertEquals(HttpStatus.CREATED, result.getStatusCode());

		 log.info("End initDatabase");
	}

	@After
	public void clearDatabase() {
		log.info("Begin clearDatabase");
		repository.deleteAll();
		log.info("End clearDatabase");
	}

	@Test
	public void testGetAll_OK() {
		log.info("Begin test testGetAll");
		List<ModelDto> models = service.findAll();
		log.info("Models size {}", models.size());
		assertTrue(models.size() == 1);
		log.info("End test testGetAll");
	}

	@Test(expected = AssertionError.class)
	public void testByName_KO() {
		log.info("Begin test testByName");
		List<ModelDto> models = service.findAllByName("modelName");
		log.info("Models size {}", models.size());
		assertTrue(models.size() == 10);
		log.info("End test testByName");
	}

	@Test
	public void testAdd_OK() {
		log.info("Begin test testAdd");

		 EngineDto e = new EngineDto();
		 e.setPower(100);
		 e.setType("engineType2");

		 WheelsDto w = new WheelsDto();
		 w.setSize("50");
		 w.setType("wheelsType2");

		 ModelDto m = new ModelDto();
		 m.setEngine(e);
		 m.setWheels(w);
		 m.setName("modelName2");


		 ResponseEntity<?> result = controller.add(m, null);
		 assertEquals(HttpStatus.CREATED, result.getStatusCode());

		 List<ModelDto> models = service.findAll();
		 log.info("Models size {}", models.size());
		 assertTrue(models.size() == 2);

		 log.info("End test testAdd");
	}

}
