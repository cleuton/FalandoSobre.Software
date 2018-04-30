package com.obomprogramador.temperatura.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.obomprogramador.temperatura.util.DateAdapter;

@SuppressWarnings("serial")
@XmlRootElement
public class Temperatura implements Serializable {
	public double latitude;
	public double longitude;
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date data;
	public double temperatura;
}
