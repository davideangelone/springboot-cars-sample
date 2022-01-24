package com.carseller.cars.tasks;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.carseller.cars.beans.CatalogueDto;
import com.carseller.cars.beans.ModelDto;
import com.carseller.cars.services.ICarsService;
import com.carseller.cars.utils.XmlUtils;

@Slf4j
@Service
public class FordIngesterTask {

	@Autowired
	ICarsService carsService;

	@Scheduled(cron = "${cars.ford.ingester.runCron}")
	public void ingestFile() {
		  try {
			  CatalogueDto c = XmlUtils.unmarshal(CatalogueDto.class, "ford-example.xml");
			  log.info("File unmarshalled");

			  /*
			  for (ModelDto m : c.getModels()) {
				  log.info("Name {}, From {}, To {}, Type {}, Line {}, ", m.getName(), m.getFrom(), m.getTo(), m.getType(), m.getLine());
				  for (ModelDto s : m.getSubModels().getModels()) {
					  log.info("SubModel - Name {}, From {}, To {}, Type {}, Line {}, ", s.getName(), s.getFrom(), s.getTo(), s.getType(), s.getLine());
				  }
			  }
			  */

			  carsService.deleteAll();
			  c.getModels().stream().forEach(carsService::save);

			  log.info("Items saved");
		  } catch (Exception e) {
			  log.error("Error processing task {}", e);
		  }
	}
}
