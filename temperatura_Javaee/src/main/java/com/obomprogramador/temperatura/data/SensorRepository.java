package com.obomprogramador.temperatura.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.obomprogramador.temperatura.model.Medida;
import com.obomprogramador.temperatura.model.Sensor;
import com.obomprogramador.temperatura.model.Temperatura;

@ApplicationScoped
public class SensorRepository {

    @Inject
    private EntityManager em;
    
    @Inject
    Logger log;


    public Sensor findByLatitudeLongitude(double latitude, double longitude)
    	throws NoResultException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sensor> criteria = cb.createQuery(Sensor.class);
        Root<Sensor> sensor = criteria.from(Sensor.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(sensor.get("latitude"), latitude));
        predicates.add(cb.equal(sensor.get("longitude"), longitude));
        criteria.select(sensor)
        	.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(criteria).getSingleResult();    	
    }
    
    
    public List<Temperatura> listMedidas(Date data) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(data);
    	cal.add(Calendar.DATE, -1);
    	Date ontem = cal.getTime();
    	cal.add(Calendar.DATE,  2);
    	Date amanha = cal.getTime();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Medida> criteria = cb.createQuery(Medida.class);
        Root<Medida> medida = criteria.from(Medida.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.greaterThan(medida.<Date>get("data"), ontem));
        predicates.add(cb.lessThan(medida.<Date>get("data"), amanha));
        criteria.select(medida)
        	.where(predicates.toArray(new Predicate[]{}));
        List<Medida> lista = em.createQuery(criteria).getResultList();
        List<Temperatura> temps = new ArrayList<Temperatura>();
        for (Medida m : lista) {
        	Temperatura temp = new Temperatura();
        	temp.data = m.getData();
        	temp.latitude = m.getSensor().getLatitude();
        	temp.longitude = m.getSensor().getLongitude();
        	temp.temperatura = m.getTemperatura();
        	temps.add(temp);
        }
        return temps;	   	
    }
	
}
