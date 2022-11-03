package com.sanchez.examen1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchez.examen1.model.UsuarioModel;
import com.sanchez.examen1.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApi {
    
    @Autowired
    private UsuarioService us;

    @PostMapping("/register")
    public int saveUsuario(@RequestBody UsuarioModel usuario){
        return us.create(usuario);
    }
    
}
