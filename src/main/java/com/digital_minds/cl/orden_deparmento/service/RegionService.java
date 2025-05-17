package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Region;
import com.digital_minds.cl.orden_deparmento.repository.RegionRepository;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public Region save(Region region){
        return regionRepository.save(region);

    }
    public void delete(Integer id){
        regionRepository.deleteById(id);
    }
    public List<Region> findAll(){
        return regionRepository.findAll();

    }
    public Region findById(Integer id){
        return regionRepository.findById(id).orElse(null);
    }

    public Region patchRegion(Integer id, Region parcialRegion){
        Optional<Region> regionOptional = regionRepository.findById(id);
        if (regionOptional.isPresent()) {
            
            Region regionToUpdate = regionOptional.get();
            
            if (parcialRegion.getNombreRegion() != null) {
                regionToUpdate.setNombreRegion(parcialRegion.getNombreRegion());   
            }

            return regionRepository.save(regionToUpdate);
        } else {
            return null; 
        }
    }

}
