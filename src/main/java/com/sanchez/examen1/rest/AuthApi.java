package com.sanchez.examen1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchez.examen1.dto.LoginDto;
import com.sanchez.examen1.model.UsuarioModel;
import com.sanchez.examen1.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthApi {
	
	@Autowired
    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
		return ResponseEntity.ok(authService.login(loginDto));
    }
    
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> getUsuario() {
		return ResponseEntity.ok(authService.getUsuario());
    }
}
