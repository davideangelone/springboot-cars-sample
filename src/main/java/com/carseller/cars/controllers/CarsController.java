package com.carseller.cars.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carseller.cars.beans.ModelDto;
import com.carseller.cars.services.ICarsService;
import com.carseller.error.Errore;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cars")
public class CarsController {

	@Autowired
	ICarsService carsService;

    /**
     * Rstituisce il catalogo di tutte le auto
     */
    @GetMapping("/get")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
        })
    public ResponseEntity<List<ModelDto>> getAll() {
    	List<ModelDto> res = this.carsService.findAll();
    	return ResponseEntity.ok(res);
    }

    /**
     * Restituisce le caratteristiche di un'auto tramite ID
     *
     * @param id utente
     * @return utente
     */
    @GetMapping("/get/id/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Auto non trovata")
        })
    public ResponseEntity<List<ModelDto>> getById(@PathVariable("id") int id) {
    	List<ModelDto> res = this.carsService.findAllById(id);
        return res.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(res);
    }


    /**
     * Restituisce le caratteristiche di un'auto tramite marca
     *
     * @param id utente
     * @return utente
     */
    @GetMapping("/get/type/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Auto non trovata")
        })
    public ResponseEntity<List<ModelDto>> getByName(@PathVariable("name") String name) {
    	List<ModelDto> res = this.carsService.findAllByName(name);
        return res.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(res);
    }


    /**
     * Aggiunge un modello di auto
     *
     * @param Modello auto
     */
    @PostMapping("/add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Input non valido"),
            @ApiResponse(responseCode = "409", description = "Auto gia' presente")
        })
    public ResponseEntity<?> add(@Valid @RequestBody ModelDto modelDto, Errors errors) {
    	if ((null != errors) && errors.hasErrors()) {
    		List<Errore> errs = new ArrayList<>();
    		errors.getFieldErrors().stream().forEach(fe -> errs.add(new Errore(fe.getField(), fe.getDefaultMessage())));
    		return ResponseEntity.badRequest().body(errs);
    	}
    	if (this.carsService.existsByName(modelDto.getName())) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).build();
    	}
    	else {
    		this.carsService.save(modelDto);
    		return ResponseEntity.status(HttpStatus.CREATED).build();
    	}
    }


}
