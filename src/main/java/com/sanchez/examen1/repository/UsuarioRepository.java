package com.sanchez.examen1.repository;

import com.sanchez.examen1.model.UsuarioModel;

public interface UsuarioRepository {
	int create(UsuarioModel obj);
	
    UsuarioModel findByEmail(String email);
}
