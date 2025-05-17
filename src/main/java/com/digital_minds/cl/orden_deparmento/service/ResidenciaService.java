package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;
import java.util.Optional;

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

    public Residencia patchResidencia(Integer id, Residencia parcialResidencia){
        Optional<Residencia> residenciaOptional = residenciaRepository.findById(id);
        if (residenciaOptional.isPresent()) {
            
            Residencia residenciaToUpdate = residenciaOptional.get();
            
            if (parcialResidencia.getNombreResidencia() != null) {
                residenciaToUpdate.setNombreResidencia(parcialResidencia.getNombreResidencia());   
            }

            if (parcialResidencia.getDireccion() != null) {
                residenciaToUpdate.setDireccion(parcialResidencia.getDireccion());   
            }

            if (parcialResidencia.getTelefono() != null) {
                residenciaToUpdate.setTelefono(parcialResidencia.getTelefono());   
            }

            if (parcialResidencia.getCorreo() != null) {
                residenciaToUpdate.setCorreo(parcialResidencia.getCorreo());   
            }

            if (parcialResidencia.getSitioWeb() != null) {
                residenciaToUpdate.setSitioWeb(parcialResidencia.getSitioWeb());   
            }

            return residenciaRepository.save(residenciaToUpdate);
        } else {
            return null; 
        }
    }
}
