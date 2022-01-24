package com.carseller.cars.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SUBMODELS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SubmodelsDto {
	
	private List<ModelDto> models;

	@XmlElement(name="MODEL")
	public List<ModelDto> getModels() {
		return models;
	}

	public void setModels(List<ModelDto> models) {
		this.models = models;
	}
	
}