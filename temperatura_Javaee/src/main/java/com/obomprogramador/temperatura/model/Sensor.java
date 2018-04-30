package com.obomprogramador.temperatura.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Sensor implements Serializable {

	@Id
	private String id;
	private double latitude;
	private double longitude;
	
	@OneToMany(mappedBy = "sensor")
	private List<Medida> medidas;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public List<Medida> getMedidas() {
		return medidas;
	}
	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}
	
	
}
