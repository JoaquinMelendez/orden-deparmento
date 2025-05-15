package com.digital_minds.cl.orden_deparmento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital_minds.cl.orden_deparmento.model.Usuario;
import com.digital_minds.cl.orden_deparmento.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario agregarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).get();
    }
    
    public Usuario patchUsuario(Long id, Usuario parcialUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            
            Usuario UsuarioToUpdate = usuarioOptional.get();
            
            if (parcialUsuario.getNombre() != null) {
                UsuarioToUpdate.setNombre(parcialUsuario.getNombre());   
            }

            if(parcialUsuario.getApellidoPaterno() != null) {
                UsuarioToUpdate.setApellidoPaterno(parcialUsuario.getApellidoPaterno());
            }

            if(parcialUsuario.getApellidoMaterno() != null) {
                UsuarioToUpdate.setApellidoMaterno(parcialUsuario.getApellidoMaterno());
            }

            if(parcialUsuario.getFechaNacimiento() != null) {
                UsuarioToUpdate.setFechaNacimiento(parcialUsuario.getFechaNacimiento());
            }

            if(parcialUsuario.getCorreo() != null) {
                UsuarioToUpdate.setCorreo(parcialUsuario.getCorreo());
            }

            if(parcialUsuario.getRun() != null) {
                UsuarioToUpdate.setRun(parcialUsuario.getRun());
            }

            return usuarioRepository.save(UsuarioToUpdate);
        } else {
            return null; // or throw an exception
        }    
    }
}