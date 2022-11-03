package com.sanchez.examen1.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sanchez.examen1.model.TareaModel;

public class TareaMapper implements RowMapper<TareaModel> {
	@Override
    public TareaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		TareaModel tarea = new TareaModel();        
		tarea.setId(rs.getInt("id"));
		tarea.setDescripcion(rs.getString("descripcion"));
		tarea.setEstado(rs.getString("estado"));
		tarea.setUsuarioId(rs.getInt("usuario_id"));
		
        return tarea;
    }
}
