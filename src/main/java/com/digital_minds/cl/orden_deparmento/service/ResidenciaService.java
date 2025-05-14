package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Residencia;
import com.digital_minds.cl.orden_deparmento.repository.ResidenciaRepository;

@Service
public class ResidenciaService {

    @Autowired
    private ResidenciaRepository residenciaRepository;

    public Residencia save(Residencia residencia){
        return residenciaRepository.save(residencia);

    }
    public void delete(Integer id){
        residenciaRepository.deleteById(id);
    }
    public List<Residencia> findAll(){
        return residenciaRepository.findAll();

    }
    public Residencia findById(Integer id){
        return residenciaRepository.findById(id).orElse(null);
    }

    public Residencia updateResidencia(Long id, Residencia residencia){
        Residencia existente = residenciaRepository.findById(id.intValue()).orElse(null);
        if (existente != null){
            existente.setNombreResidencia(residencia.getNombreResidencia());
            existente.setDireccion(residencia.getDireccion());

            return residenciaRepository.save(existente);
        }
        return null;
    }

    
   

}
