package com.sanchez.examen1.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sanchez.examen1.components.Jwt;
import com.sanchez.examen1.dto.LoginDto;
import com.sanchez.examen1.model.UsuarioModel;
import com.sanchez.examen1.services.AuthService;


@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
    private Jwt jwtl;
	
	public String login(LoginDto loginDto) {
    	try {
    		Authentication autenticaicon = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password));
    		
    		UsuarioModel usuario = (UsuarioModel) autenticaicon.getPrincipal();

    		String token = jwtl.generate(usuario);

    		return token;
    	} catch (Exception e) {
    		return e.toString();
    	}
	}
	
	public UsuarioModel getUsuario() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UsuarioModel usuario = (UsuarioModel) authentication.getPrincipal();

		return usuario;
	}
}
