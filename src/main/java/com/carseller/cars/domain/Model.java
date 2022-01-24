package com.carseller.cars.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MODEL")
@Getter
@Setter
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MODEL_ID")
	private Integer id;

	@NotEmpty
	@Column(name="NAME")
	private String name;

	@Column(name="FROMFIELD")
	private Integer from;

	@Column(name="TO")
	private Integer to;

	@Column(name="TYPE")
	private String type;

	@Column(name="LINE")
	private String line;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ENGINE_ID")
	private Engine engine;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName = "WHEELS_ID")
	private Wheels wheels;

}
