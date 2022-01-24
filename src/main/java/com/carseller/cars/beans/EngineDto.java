package com.carseller.cars.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ENGINE")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EngineDto {

	@Min(value=1, message="Power deve essere positivo")
	private Integer power;

	@NotBlank(message = "Type obbligatorio")
	private String type;

	@XmlAttribute
	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
