package com.sanchez.examen1.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanchez.examen1.model.UsuarioModel;
import com.sanchez.examen1.repository.UsuarioRepository;
import com.sanchez.examen1.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
    private UsuarioRepository repo;
	
	@Override
	public int create(UsuarioModel usuario) {
		return repo.create(usuario);
	}

	@Override
	public UsuarioModel findByEMail(String email) {
		return repo.findByEmail(email);
	}

}
