package com.carseller.cars.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "MODEL")
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonInclude(Include.NON_NULL)
public class ModelDto {

	private Integer id;

	@NotBlank(message = "Nome obbligatorio")
	private String name;

	private Integer from;

	private Integer to;

	private String type;

	private String line;

	@Valid
	private EngineDto engine;

	@Valid
	private WheelsDto wheels;

	@Valid
	private SubmodelsDto subModels;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	@XmlAttribute
	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@XmlElement(name="ENGINE")
	public EngineDto getEngine() {
		return engine;
	}

	public void setEngine(EngineDto engine) {
		this.engine = engine;
	}

	@XmlElement(name="WHEELS")
	public WheelsDto getWheels() {
		return wheels;
	}

	public void setWheels(WheelsDto wheels) {
		this.wheels = wheels;
	}

	@XmlElement(name="SUBMODELS")
	public SubmodelsDto getSubModels() {
		return subModels;
	}

	public void setSubModels(SubmodelsDto subModels) {
		this.subModels = subModels;
	}

}
