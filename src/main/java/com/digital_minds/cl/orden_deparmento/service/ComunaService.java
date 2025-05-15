package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Comuna;
import com.digital_minds.cl.orden_deparmento.repository.ComunaRepository;

@Service
public class ComunaService {


    @Autowired
    private ComunaRepository comunaRepository;

    public Comuna save(Comuna comuna){
        return comunaRepository.save(comuna);

    }
    public void delete(Integer id){
        comunaRepository.deleteById(id);
    }
    public List<Comuna> findAll(){
        return comunaRepository.findAll();

    }
    public Comuna findById(Integer id){
        return comunaRepository.findById(id).orElse(null);
    }


}
