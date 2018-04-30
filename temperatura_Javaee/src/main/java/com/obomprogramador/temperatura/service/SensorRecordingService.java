package com.obomprogramador.temperatura.service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.obomprogramador.temperatura.data.SensorRepository;
import com.obomprogramador.temperatura.model.Medida;
import com.obomprogramador.temperatura.model.Sensor;
import com.obomprogramador.temperatura.model.Temperatura;

@Stateless
public class SensorRecordingService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    @Inject
    private SensorRepository repository;    
    
    public void gravar(Temperatura temperatura) {
    	Sensor sensor = null;
    	try {
    		sensor = repository
    			.findByLatitudeLongitude(temperatura.latitude, temperatura.longitude);
    	}
    	catch (NoResultException nr) {
    		// Sensor não existe
    		sensor = new Sensor();
    		sensor.setId(UUID.randomUUID().toString());
    		sensor.setLatitude(temperatura.latitude);
    		sensor.setLongitude(temperatura.longitude);
    		sensor.setMedidas(new ArrayList<Medida>());
        	log.info("Gravando chave: " + sensor.getId());
        	em.persist(sensor);
        	em.flush();
    	}
    	Medida medida = new Medida();
    	medida.setData(temperatura.data);
    	medida.setSensor(sensor);
    	medida.setTemperatura(temperatura.temperatura);
    	medida.setId(UUID.randomUUID().toString());
    	em.persist(medida);
    	sensor.getMedidas().add(medida);
    	
    	log.info("Atualizando chave: " + sensor.getId());
    	em.merge(sensor);
    	em.flush();
    	
    }
	
}
