package com.sanchez.examen1.repository.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sanchez.examen1.mappers.TareaMapper;
import com.sanchez.examen1.model.TareaModel;
import com.sanchez.examen1.repository.TareaRepository;


@Repository
public class TareaRepositoryImpl implements TareaRepository {

	@Autowired
    JdbcTemplate template;

	@Override
	public List<TareaModel> getAll() {
		String sql = "Select * from tareas order by id;";
        return template.query(sql, new TareaMapper());
	}

	@Override
	public TareaModel getById(Integer id) {
		String sql = "Select * from tareas where id = %d";
		sql = String.format(sql, id);
        return template.queryForObject(sql, new TareaMapper());
	}

	@Override
	public int create(TareaModel obj) {
		String sql = "Insert into tareas(descripcion, estado, usuario_id) values(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, obj.getDescripcion());
            ps.setString(2, obj.getEstado());
            ps.setInt(3, obj.getUsuarioId());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
	}

	@Override
	public void update(TareaModel obj) {
		String sql =  "update tareas set descripcion = ?, estado = ?, usuario_id = ? where id = ?";
        template.update(sql, obj.getDescripcion(), obj.getEstado(), obj.getUsuarioId(), obj.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from tareas where id = ?";
        template.update(sql, id);
	}

}
