package com.carseller.cars.beans;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WHEELS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WheelsDto {

	@NotBlank(message = "Size obbligatorio")
	private String size;

	@NotBlank(message = "Type obbligatorio")
	private String type;

	@XmlAttribute
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
