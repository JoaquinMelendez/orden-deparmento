package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.TipoResidencia;
import com.digital_minds.cl.orden_deparmento.repository.TipoResidenciaRepository;

@Service
public class TipoResidenciaService {

    @Autowired
    private TipoResidenciaRepository tipoResidenciaRepository;

    public TipoResidencia save(TipoResidencia tipoResidencia){
        return tipoResidenciaRepository.save(tipoResidencia);

    }
    public void delete(Integer id){
        tipoResidenciaRepository.deleteById(id);
    }
    public List<TipoResidencia> findAll(){
        return tipoResidenciaRepository.findAll();

    }
    public TipoResidencia findById(Integer id){
        return tipoResidenciaRepository.findById(id).orElse(null);
    }

    public TipoResidencia patchTipoResidencia(Integer id, TipoResidencia parcialTipoResidencia){
        Optional<TipoResidencia> tipoResidenciaOptional = tipoResidenciaRepository.findById(id);
        if (tipoResidenciaOptional.isPresent()) {
            
            TipoResidencia tipoResidenciaToUpdate = tipoResidenciaOptional.get();
            
            if (parcialTipoResidencia.getNombreTipoResidencia() != null) {
                tipoResidenciaToUpdate.setNombreTipoResidencia(parcialTipoResidencia.getNombreTipoResidencia());   
            }

            return tipoResidenciaRepository.save(tipoResidenciaToUpdate);
        } else {
            return null; 
        }
    }

}
