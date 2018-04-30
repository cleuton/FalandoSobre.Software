package com.obomprogramador.temperatura.rest;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.obomprogramador.temperatura.data.SensorRepository;
import com.obomprogramador.temperatura.model.Medida;
import com.obomprogramador.temperatura.model.Temperatura;
import com.obomprogramador.temperatura.service.SensorRecordingService;


@Path("sensor")
@RequestScoped
public class SensorREST {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private SensorRepository repository;
    
    @Inject
    SensorRecordingService registration;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> listAllMedidas() {
        return repository.listMedidas(new Date());
    }   
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response storeTemperature(Temperatura temperatura) {
    	registration.gravar(temperatura);
    	Response.ResponseBuilder builder = Response.ok("{'status':'ok'}");
    	return builder.build();
    }
}
