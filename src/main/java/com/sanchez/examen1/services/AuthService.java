package com.sanchez.examen1.services;

import com.sanchez.examen1.dto.LoginDto;
import com.sanchez.examen1.model.UsuarioModel;

public interface AuthService {
	public String login(LoginDto loginDto);
	
	public UsuarioModel getUsuario();
}
