package com.sanchez.examen1.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sanchez.examen1.model.UsuarioModel;

public class UsuarioMapper implements RowMapper<UsuarioModel> {
	@Override
    public UsuarioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioModel usuario = new UsuarioModel();        
        usuario.setId(rs.getInt("id"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setEmail(rs.getString("email"));
        usuario.setPassword(rs.getString("password"));
        
        return usuario;
    }
}
