package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digital_minds.cl.orden_deparmento.model.EstadoReserva;
import com.digital_minds.cl.orden_deparmento.repository.EstadoReservaRepository;

@Controller
@RequestMapping("/api/v1/estadosReseva")
public class EstadoReservaController {

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public EstadoReserva agregarEstadoReserva(EstadoReserva estadoReserva){
        return estadoReservaRepository.save(estadoReserva);
    }

    public void eliminarUsuario(Integer id){
        estadoReservaRepository.deleteById(id);
    }

    public List<EstadoReserva> buscarTodos(){
        return estadoReservaRepository.findAll();
    }

    public EstadoReserva buscarPorId(Integer id){
        return estadoReservaRepository.findById(id).get();
    }

}
