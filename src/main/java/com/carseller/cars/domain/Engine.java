package com.carseller.cars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ENGINE")
@Getter
@Setter
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ENGINE_ID")
	private Integer id;

	@NotNull
	@Column(name="POWER")
	private Integer power;

	@NotEmpty
	@Column(name="TYPE")
	private String type;

}
