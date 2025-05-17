package com.digital_minds.cl.orden_deparmento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_minds.cl.orden_deparmento.model.Usuario;
import com.digital_minds.cl.orden_deparmento.service.UsuarioService;




@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Devolver todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = usuarioService.buscarTodos();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    //buscar usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Integer id) {
        Usuario usuarioBuscado = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuarioBuscado);
    }
    
    //Agregar nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.agregarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
    
    //Quitar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> quitarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
       Usuario usuarioActualizada = usuarioService.patchUsuario(id, usuario);
       if (usuarioActualizada != null){
        return ResponseEntity.ok(usuarioActualizada);
       }
       return ResponseEntity.notFound().build();
    }

    //Actualizar usuario
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> actualizarParcial(@PathVariable Integer id, @RequestBody Usuario parcialUsuario) {
        Usuario usuarioActualizado = usuarioService.patchUsuario(id, parcialUsuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
