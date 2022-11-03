package com.sanchez.examen1.services;

import com.sanchez.examen1.model.UsuarioModel;

public interface UsuarioService {
	int create(UsuarioModel obj);
	
	UsuarioModel findByEMail(String email);
}
