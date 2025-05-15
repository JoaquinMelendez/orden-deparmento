package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Ciudad;
import com.digital_minds.cl.orden_deparmento.repository.CiudadRepository;

@Service
public class CiudadService {


    @Autowired
    private CiudadRepository ciudadRepository;

    public Ciudad save(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }
    public void delete(Integer id){
        ciudadRepository.deleteById(id);
    }
    public List<Ciudad> findAll(){
        return ciudadRepository.findAll();
    }
    public Ciudad findById(Integer id){
        return ciudadRepository.findById(id).orElse(null);
    }
    public Ciudad updateCiudad(Integer id, Ciudad ciudad){
        Ciudad existente = ciudadRepository.findById(id.intValue()).orElse(null);
        if (existente != null){
            existente.setNombreCiudad(ciudad.getNombreCiudad());

            return ciudadRepository.save(existente);

        }
        return null;
    }



}
