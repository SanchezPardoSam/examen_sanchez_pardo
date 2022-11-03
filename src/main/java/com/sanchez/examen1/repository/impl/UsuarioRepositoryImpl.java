package com.sanchez.examen1.repository.impl;


import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sanchez.examen1.components.Encoder;
import com.sanchez.examen1.mappers.UsuarioMapper;
import com.sanchez.examen1.model.UsuarioModel;
import com.sanchez.examen1.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	@Autowired
	private Encoder enc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(UsuarioModel usr) {		
		String sql = "insert into usuarios(activo, email, nombre, password) VALUES(b'1', ?, ?, ?)";		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, usr.getEmail());
                ps.setString(2, usr.getNombre());
				ps.setString(3, enc.encodePassword(usr.getPassword()));
				return ps;
		}, keyHolder);		
		return keyHolder.getKey().intValue();
	}

    @Override
    public UsuarioModel findByEmail(String username) {		
		String sql = "select * from usuarios where activo = 1 and email = '%s';";		
		sql = String.format(sql, username);
		return jdbcTemplate.queryForObject(sql, new UsuarioMapper());	
	}
}
