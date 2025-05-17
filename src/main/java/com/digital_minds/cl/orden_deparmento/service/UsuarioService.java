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

    public Usuario patchUsuario(Integer id, Usuario parcialUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            
            Usuario usuarioToUpdate = usuarioOptional.get();
            
            if (parcialUsuario.getCorreo() != null) {
                usuarioToUpdate.setCorreo(parcialUsuario.getCorreo());   
            }

            if (parcialUsuario.getContrasenna() != null) {
                usuarioToUpdate.setContrasenna(parcialUsuario.getContrasenna());   
            }

            if (parcialUsuario.getRun() != null) {
                usuarioToUpdate.setRun(parcialUsuario.getRun());   
            }

            if (parcialUsuario.getNombre() != null) {
                usuarioToUpdate.setNombre(parcialUsuario.getNombre());   
            }

            if (parcialUsuario.getApellidoPaterno() != null) {
                usuarioToUpdate.setApellidoPaterno(parcialUsuario.getApellidoPaterno());   
            }

            if (parcialUsuario.getApellidoMaterno() != null) {
                usuarioToUpdate.setApellidoMaterno(parcialUsuario.getApellidoMaterno());   
            }

            if (parcialUsuario.getFechaNacimiento() != null) {
                usuarioToUpdate.setFechaNacimiento(parcialUsuario.getFechaNacimiento());   
            }
            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null; 
        }
    }

}
