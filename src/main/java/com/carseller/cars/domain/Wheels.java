package com.carseller.cars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WHEELS")
@Getter
@Setter
public class Wheels {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="WHEELS_ID")
	private Integer id;

	@NotEmpty
	@Column(name="SIZE")
	private String size;

	@NotEmpty
	@Column(name="TYPE")
	private String type;

}
