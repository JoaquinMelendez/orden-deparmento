package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.EstadoReserva;
import com.digital_minds.cl.orden_deparmento.repository.EstadoReservaRepository;

@Service
public class EstadoReservaService {

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public EstadoReserva agregarEstadoReserva(EstadoReserva estadoReserva){
        return estadoReservaRepository.save(estadoReserva);
    }

    public void eliminarEstadoReserva(Integer id){
        estadoReservaRepository.deleteById(id);
    }

    public List<EstadoReserva> buscarTodos(){
        return estadoReservaRepository.findAll();
    }

    public EstadoReserva buscarPorId(Integer id){
        return estadoReservaRepository.findById(id).get();
    }




}
